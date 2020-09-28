package com.sky.ham.controller;

import com.alibaba.fastjson.JSON;
import com.sky.ham.entity.Album;
import com.sky.ham.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/album")
public class AlbumController {
    @Resource
    private AlbumService albumService;

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
