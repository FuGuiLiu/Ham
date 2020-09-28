package com.sky.ham.util;

import com.sky.ham.entity.Album;
import com.sky.ham.service.AlbumService;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AlbumTest {
    private AlbumService albumService;

    {
        this.albumService = (AlbumService) BeanUtils.getBean("albumServiceImpl");
    }

    @Test
    public void albumCountTest() {
        Album album = new Album();
//        album.setLANG("汉语");
//        album.setANAME("做");
//        album.setCOMPANY("华");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        album.setPDATE("2008-09-09");

        Integer integer = albumService.queryAlbumCount(album);
        System.out.println(integer);
    }

    @Test
    public void albumInfoQuery() {
        Album album = new Album();
//        album.setPDATE("2008-09-09");
        List<Album> albums = albumService.queryAlbumInfos(album, 2, 5);
        for (Album s : albums) {
//            日期  Wed Oct 05 08:00:00 CST 2016

//            Tue Sep 09 00:00:00 CST 2008
            System.out.println(s.toString());
        }
    }

    @Test
    public void albumAddTest() {
//        Album album = new Album();
//        album.setLANG("英语");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Integer integer = albumService.addAlbumInfo(new Album(null, "test", "test", "test", "2020-1-1", "test"));
//        System.out.println(integer);
    }

    @Test
    public void albumUpdateTest() {
        Album album = new Album();
        album.setANAME("a");
        album.setLANG("a");
        album.setCOMPANY("a");
        album.setPIC("a");
        album.setPDATE("2021-02-01");
//        Integer integer = albumService.updateAlbumInfo(album, 11);
//        System.out.println(integer);
    }

    @Test
    public void albumDeleteTest() {
//        Integer integer = albumService.deleteAlbumInfo(11);
//        System.out.println(integer);
    }
}
