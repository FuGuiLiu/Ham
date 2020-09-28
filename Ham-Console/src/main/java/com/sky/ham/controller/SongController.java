package com.sky.ham.controller;


import com.alibaba.fastjson.JSON;
import com.sky.ham.entity.Song;
import com.sky.ham.service.AlbumService;
import com.sky.ham.service.MTypeService;
import com.sky.ham.service.SingerService;
import com.sky.ham.service.SongService;
import com.sky.ham.util.FileDeletion;
import com.sky.ham.util.Page;

import com.sky.ham.util.PropUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/song")
public class SongController {
    // TODO: 2020/9/23      注入SongService组件
    @Resource
    private SongService songService;
    @Resource
    private SingerService singerService;
    @Resource
    private MTypeService mTypeService;
    @Resource
    private AlbumService albumService;

    @RequestMapping("/list")
    public String songList(@ModelAttribute(value = "Song") Song song, @RequestParam(value = "currentNo", required = false) String currentNo, Model model) {
        //设置一个最终的页面量
        final int pageSize = 5;
        //声明默认起始页
        int startNo = 1;

        if (currentNo != null) {
            startNo = Integer.parseInt(currentNo);
        }

        if (song.getSNAME() != null) {
            model.addAttribute("SNAME", song.getSNAME());
        }
        if (song.getSRNAME() != null) {
            model.addAttribute("SRNAME", song.getSRNAME());
        }
        if (song.getANAME() != null) {
            model.addAttribute("ANAME", song.getANAME());
        }
        if (song.getTID() != null) {
            model.addAttribute("TID", song.getTID());
        }

        List<Song> songs = songService.querySongInfos(song, startNo, pageSize);


        model.addAttribute("songs", songs);

        Page page = new Page();
        page.setCurrentPage(startNo);
//        设置页面量
        page.setPageSize(pageSize);
        //设置总记录数
        page.setTotalCount(songService.querySongCounts(song));
        //获取总页数
        int totalPageCount = page.getPageCount();

        model.addAttribute("currentNo", startNo);
        model.addAttribute("songs", songs);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("mTypes", mTypeService.queryMTypeInfos());
        return "/song";
    }

    @RequestMapping(value = "/addSong", method = RequestMethod.GET)
    public String addSong(Model model) {
        model.addAttribute("singers", singerService.queryAllSingers());
        model.addAttribute("albums", albumService.queryAllAlbumInfos());
        model.addAttribute("mTypes", mTypeService.queryMTypeInfos());
        return "/addSong";
    }

    @RequestMapping(value = "/addSong", method = RequestMethod.POST)
    public String addSong(@ModelAttribute @Validated Song song, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "/mistake";
        } else {
            song.setPIC(albumService.queryAlbumInfoByAID(song.getAID()).getPIC());
            Integer integer = songService.addSong(song);
            if (integer == 1) {
                return "redirect:/song/list.go";
            }
        }
        return "redirect:/song/list.go";
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadFile(@RequestParam(value = "mp3file") MultipartFile multipartFile, HttpServletRequest request, Model model, String lastMp3) throws IOException {
        if (multipartFile != null) {
            byte[] bytes = multipartFile.getBytes();
            String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
//            设置文件上传的根路径
            String rootPath = PropUtil.read("localSongsPath");


            String relativePath = UUID.randomUUID().toString().toUpperCase().replace("-", "") + "." + extension;
//            获取文件上传的完整路径

            String fullPath = rootPath + relativePath;
            //创建jersey  将文件上传到服务器上
            Client client = Client.create();
            if (lastMp3 != null && !"".equals(lastMp3)) {
                WebResource webResource = client.resource(lastMp3);
                webResource.delete();
            }
            WebResource webResource = client.resource(fullPath);
            try {
                webResource.put(bytes);
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }

            Map<String, String> path = new HashMap<>();
            path.put("realPath", fullPath);
            path.put("relativePath", relativePath);
            return JSON.toJSONString(path);
        }
        return "error";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String deleteSong(@RequestParam(value = "SID") String SID, Model model) {
        if (SID != null) {
            Song song = songService.querySongInfo(Integer.parseInt(SID));
            model.addAttribute("isModify", "yes");
            model.addAttribute("song", song);
            model.addAttribute("singers", singerService.queryAllSingers());
            model.addAttribute("albums", albumService.queryAllAlbumInfos());
            model.addAttribute("mTypes", mTypeService.queryMTypeInfos());
        }

        return "/addSong";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifySong(@ModelAttribute(value = "SID") @Validated Song song, BindingResult bindingResult, Model model) {
//        bindingResult
        if (bindingResult.hasErrors()) {
            return "/mistake";
        } else {
            song.setPIC(singerService.querySingerInfoBySID(song.getSID()).getPIC());
            Integer integer = songService.updateSong(song);
            if (integer == 1) {
                return "redirect:/song/list.go";
            }
        }
        return "redirect:/song/list.go";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteSong(@RequestParam(value = "SID") String SID, HttpServletRequest request) {
        if (SID != null) {
            FileDeletion.FileHelper.removeFile(request.getSession().getServletContext().getRealPath("/") + songService.querySongInfo(Integer.parseInt(SID)).getMP3());
            Integer integer = songService.deleteSong(Integer.parseInt(SID));
            if (integer == 1) {
                return "redirect:/song/list.go";
            }
        }
        return "redirect:/song/list.go";
    }


}
