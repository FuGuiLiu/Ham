package com.sky.ham.controller;

import com.alibaba.fastjson.JSON;
import com.sky.ham.entity.Album;
import com.sky.ham.entity.Song;
import com.sky.ham.service.AlbumService;
import com.sky.ham.service.SongService;
import com.sky.ham.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
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

    /**
     * 单曲播放
     *
     * @param sid
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/playSingleSong", method = RequestMethod.GET)
    public String playSongs(@RequestParam(value = "ids") String sid, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(sid);
        List<Integer> ids = new ArrayList<>();

        //获取cookie
        Cookie[] cookie = request.getCookies();
        //已经存在cookie中的歌曲信息
        String[] oldSongLists = null;
        //cookie中的歌曲名称
        String oldName;
        //最后要放在最后的列表
        List<Song> allSongsList = new ArrayList<>();
        //当前点的歌曲
        Song song = null;
//        新的cookie,音乐id字符串
        String oldPids = null;
//新的cookie,音乐id字符串
        String playedSongsIDS = "";

        if (sid != null && "" != sid) {
            if (null != cookie && cookie.length > 0) {
                for (int i = 0; i < cookie.length; i++) {
                    if ("playedSongs".equals(cookie[i].getName())) {
                        oldPids = URLDecoder.decode(cookie[i].getValue(), "UTF-8");
                    }
                }
                song = songService.querySongInfo(Integer.parseInt(sid));

                if (oldPids != null) {
                    oldSongLists = oldPids.split("-");
                }
            }


            if (oldSongLists != null) {

                for (int i = 0; i < oldSongLists.length; i++) {
                    if (!oldSongLists[i].contains(song.getSID().toString())) {
                        ids.add(Integer.parseInt(oldSongLists[i]));
                    }
                }
                //获取已经在播放页面的歌曲
                if (ids.size() > 0 && ids != null) {
                    allSongsList = songService.querySongsInfosByIDS(ids);
                }

            }

            //将新点的歌曲放入所有歌曲集合中
            allSongsList.add(song);


            if (allSongsList.size() > 0) {
                for (Song s : allSongsList) {
                    if (!"".equals(s) && allSongsList.size() > 1) {
                        playedSongsIDS += s.getSID() + "-";
                    } else {
                        playedSongsIDS = s.getSID().toString();
                    }
                }
            }
            Cookie newCookie = new Cookie("playedSongs", URLDecoder.decode(playedSongsIDS, "UTF-8"));

            newCookie.setMaxAge(60 * 60 * 24 * 30);
            newCookie.setPath("/");

            response.addCookie(newCookie);
            //放在model中进行展示
            model.addAttribute("songs", allSongsList);

            return "/player";
        }
        model.addAttribute("error", "请至少点一首歌");
        return "/mistake";
    }

    @RequestMapping("/getSong")
    @ResponseBody
    public Object getSong(@RequestParam(value = "sid") String msid, Model model) {
        if (msid != null) {
            Song song = songService.querySongInfo(Integer.parseInt(msid));
            if (song != null) {
                return JSON.toJSON(song);
            }
        }
        return "";
    }

}
