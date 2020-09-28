package com.sky.ham.controller;

import com.alibaba.fastjson.JSON;
import com.sky.ham.entity.Album;
import com.sky.ham.entity.Song;
import com.sky.ham.service.AlbumService;
import com.sky.ham.service.SongService;
import org.springframework.stereotype.Controller;
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

}
