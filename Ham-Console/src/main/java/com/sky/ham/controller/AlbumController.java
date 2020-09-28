package com.sky.ham.controller;

import com.sky.ham.entity.Album;
import com.sky.ham.service.AlbumService;
import com.sky.ham.util.FileDeletion;
import com.sky.ham.util.Page;
import com.sky.ham.util.PropUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * @author Administrator
 */

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Resource
    private AlbumService albumService;

    @RequestMapping(value = "/list")
    public String albumList(@ModelAttribute(value = "album") Album album, String currentNo, Model model) {
//        定义一个页面量
        final Integer pageSize = 5;
//        声明默认页面起始页
        Integer pageNo = 1;

        Integer totalPageCount;

        if (currentNo != null) {
            pageNo = Integer.parseInt(currentNo);
        }
        if (album.getANAME() == "" && album.getCOMPANY() == "" && album.getLANG() == "" && album.getPDATE() == "") {
            album = new Album();
        }
        List<Album> albums = albumService.queryAlbumInfos(album, pageNo, pageSize);
        if (albums.size() > 0) {
            model.addAttribute("albums", albums);
        }
        Page page = new Page();
        page.setCurrentPage(pageNo);
        page.setTotalCount(albumService.queryAlbumCount(album));
        page.setPageSize(pageSize);
//            获取总页数
        totalPageCount = page.getPageCount();
        if (totalPageCount != 0) {
//                设置页面总量
            model.addAttribute("totalPageCount", totalPageCount);
        }
//            设置当前页
        model.addAttribute("currentNo", pageNo);
//            设置条件对象
        model.addAttribute("album", album);
        return "/album";

    }


    @RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
    public String addAlbum(@ModelAttribute(value = "album") Album album, @RequestParam(value = "picfile") MultipartFile multipartFile, Model model, HttpServletRequest request) {
        if (album.getANAME().trim() != null && album.getCOMPANY().trim() != null && album.getPDATE().trim() != null && album.getLANG().trim() != null && multipartFile.getSize() > 0) {
            //校验名称是否重复
            if (albumService.queryANameExists(album.getANAME()) != 1) {
                String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
                String rootPath = PropUtil.read("localPicturesPath");
                String relativePath = java.util.UUID.randomUUID().toString().replace("-", "") + "." + extension;

                String fullPath = rootPath + relativePath;
                model.addAttribute("relativePath", relativePath);

                Client client = Client.create();
                WebResource webResource = client.resource(fullPath);

                try {
                    webResource.put(multipartFile.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                    model.addAttribute("error", e.getMessage());
                    return "/mistake";
                }

                album.setPIC(relativePath);
                Integer integer = albumService.addAlbumInfo(album);
                if (integer == 1) {
                    return "redirect:/album/list.go";
                }
            }
        } else {
            model.addAttribute("error", "请填写完整的内容");
            return "/mistake";
        }
        return "redirect:/album/list.go";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String change(@RequestParam(value = "AID") String aid, Model model, HttpServletRequest request) {
        Album album = albumService.queryAlbumInfoByAID(Integer.parseInt(aid));
        Integer integer = albumService.deleteAlbumInfo(Integer.parseInt(aid));
        if (integer == 1) {
            FileDeletion.FileHelper.removeFile(request.getSession().getServletContext().getRealPath("/") + album.getPIC());
            return "redirect:/album/list.go";
        } else {
            model.addAttribute("error", "删除失败,请稍后再试");
            return "/mistake";
        }

    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateAlbum(@RequestParam(value = "AID") String AID, Model model) {
        if (AID != null) {
            Album album = albumService.queryAlbumInfoByAID(Integer.parseInt(AID));
            model.addAttribute("album", album);
        }
        return "/addAlbum";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateAlbum(@ModelAttribute @Validated Album album, BindingResult bindingResult, MultipartFile albumPic, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "/mistake";
        } else {
            if (albumPic.getSize() > 0) {
                Client client = Client.create();
                String rootPath = PropUtil.read("localPicturesPath");
                String extension = FilenameUtils.getExtension(albumPic.getOriginalFilename());
                String relativePath = UUID.randomUUID().toString().replace("-", "").toUpperCase() + "." + extension;
                String fullPath = rootPath + relativePath;
//                删除服务器多余资源
                WebResource deleteSources = client.resource(rootPath + album.getPIC());
                try {
                    deleteSources.delete();

                    //设置新的图片资源
                    album.setPIC(relativePath);
                    //上传新的图片资源
                    WebResource webResource = client.resource(fullPath);

                    webResource.put(albumPic.getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("error", e.getMessage());
                    return "/mistake";
                }

            }
            Integer integer = albumService.updateAlbumInfo(album, album.getAID());
            if (integer == 1) {
                return "redirect:/album/list.go";
            }
        }
        model.addAttribute("error", "对不起,更新失败,请与管理员练习");
        return "/mistake";
    }
}
