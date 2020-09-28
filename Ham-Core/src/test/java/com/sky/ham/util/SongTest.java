package com.sky.ham.util;

import com.sky.ham.entity.Song;
import com.sky.ham.service.AlbumService;
import com.sky.ham.service.SongService;
import org.junit.Test;

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
}
