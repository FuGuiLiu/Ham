package com.sky.ham.util;

import com.sky.ham.entity.Album;
import com.sky.ham.entity.Song;
import com.sky.ham.service.AlbumService;
import com.sky.ham.service.SongService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SongTest {
    private SongService songService;

    {
        this.songService = (SongService) BeanUtils.getBean("songServiceImpl");
    }

    @Test
    public void queryInfo() {
        Song songs = new Song();
//        songs.setSNAME("爱");
//        songs.setSRNAME("张");
//        songs.setANAME("刻");
//        songs.setTNAME("摇滚");
        songs.setTID(10);
        List<Song> song = songService.querySongInfos(songs, 0, 10);
        for (Song s : song) {
            System.out.println(s.getSNAME() + "\n");
        }
    }

    @Test
    public void queryInfoCount() {
        // TODO: 2020/9/23 查询歌曲数量 
        Song songs = new Song();
        songs.setSNAME("爱");
//        songs.setSRNAME("张");
//        songs.setANAME("刻");
//        songs.setTID2Name("摇滚");
//        Integer integer = songService.querySongCounts(songs);
//        System.out.println(integer);
    }

    @Test
    public void songsListTest() {
//        List<Song> songs = songService.querySongInfosByAID(7);
//        for (Song song : songs) {
//            System.out.println(song.getSNAME());
//        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        List<Song> songs = songService.querySongsInfosByIDS(list);
        for (Song song : songs) {
            System.out.println(song.getSNAME());
        }
    }
}
