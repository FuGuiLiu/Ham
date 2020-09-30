package com.sky.ham.controller;

import com.alibaba.fastjson.JSON;
import com.sky.ham.entity.Album;
import com.sky.ham.service.AlbumService;
import com.sky.ham.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/album")
public class AlbumController {
    @Resource
    private AlbumService albumService;
    @Resource
    private SongService songService;

    @RequestMapping(value = "/info")
    public String albumInfo() {
        return "/album";
    }

    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object albumList(@ModelAttribute Album album) {
        List<Album> albums = albumService.queryAlbumInfos(album, 1, 10);
        return JSON.toJSONString(albums);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8"})
    @ResponseBody
    public Object queryAlbum(@RequestParam(value = "albumName") String aAame, Model model) {
        if (aAame.trim() != null || !aAame.trim().equals("")) {

            List<Album> albums = albumService.queryAlbumByFuzzyName(aAame);
            if (albums != null && albums.size() > 0) {
                return JSON.toJSONString(albums);
            } else {
                return "";
            }

        }
        return "";
    }
}
