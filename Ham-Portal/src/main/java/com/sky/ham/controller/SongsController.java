package com.sky.ham.controller;

import com.sky.ham.entity.Song;
import com.sky.ham.service.SongService;
import com.sky.ham.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
