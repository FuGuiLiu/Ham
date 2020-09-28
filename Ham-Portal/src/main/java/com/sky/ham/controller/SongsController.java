package com.sky.ham.controller;

import com.sky.ham.entity.Album;
import com.sky.ham.entity.Song;
import com.sky.ham.service.AlbumService;
import com.sky.ham.service.SongService;
import com.sky.ham.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/song")
public class SongsController {
    @Resource
    private SongService songService;
    @Resource
    private AlbumService albumService;

    @RequestMapping("/list")
    public String songs(@ModelAttribute Song song, @RequestParam(value = "currentNo", required = false) String currentNo, Model model) {
        final Integer pageSize = 6;

        Integer startNo = 1;
        if (currentNo != null) {
            startNo = Integer.parseInt(currentNo.trim());
        }
        List<Song> songs = songService.querySongInfos(song, startNo, pageSize);
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setCurrentPage(startNo);
        page.setTotalCount(songService.querySongCounts(song));

        Integer totalPageCount = page.getPageCount();
        model.addAttribute("songs", songs);
        model.addAttribute("currentNo", startNo);
        model.addAttribute("totalPageCount", totalPageCount);
        return "/songs";
    }

    @RequestMapping(value = "/songsLists", method = RequestMethod.GET)
    public Object albumDetial(@RequestParam(value = "AID") String aid, @RequestParam(value = "currentNo", required = false) String currentNo, Model model) {
        if (aid != null) {
            List<Song> songs = null;
            Album album = null;
            try {
                album = albumService.queryAlbumInfoByAID(Integer.parseInt(aid));
                songs = songService.querySongInfosByAID(Integer.parseInt(aid));
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", e.getMessage());
                return "/mistake";
            }
            model.addAttribute("songs", songs);
            model.addAttribute("album", album);
        } else {
            model.addAttribute("error", "专辑不存在");
            return "/mistake";
        }
        return "/albumDetial";
    }
}
