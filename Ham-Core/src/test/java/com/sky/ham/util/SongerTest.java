package com.sky.ham.util;

import com.sky.ham.entity.Album;
import com.sky.ham.entity.Song;
import com.sky.ham.entity.Songer;
import com.sky.ham.service.SingerService;
import org.junit.Test;

import java.util.List;

public class SongerTest {

    private SingerService singerService;

    {
        singerService = (SingerService) BeanUtils.getBean("singerServiceImpl");
    }

    @Test
    public void queryTest() {
        Songer songer = new Songer();
        songer.setSRNAME("张");
        songer.setAREA("大陆");
        songer.setTID(1);
        List<Songer> songers = singerService.querySingersInfos(songer, 0, 5);
        System.out.println(songers.size());
    }

    @Test
    public void queryCount() {
        Songer songer = new Songer();
        songer.setSRNAME("张");
        songer.setAREA("大陆");
        Integer integer = singerService.querySingerCount(songer);
        System.out.println(integer);
    }

    @Test
    public void addNewSonger() {
        Songer songer = new Songer(null, 1, "刘亦菲", "大陆", "/pictures/ss.png", 1, "非常美丽动人", null);
//        Integer integer = singerService.addSingerInfo(songer);
//        System.out.println(integer);
    }

    @Test
    public void updateSonger() {
        Songer songer = new Songer(14, 1, "刘亦菲", "美国", "pictures", 1, "女演员、歌手，籍贯河北饶阳，于湖北武汉及美国纽约成长，毕业于北京电影学院表演系2002级本科班。2002年，主演电视剧《金粉世家》进入演艺圈", null);
//        Integer integer = singerService.updateSingerInfo(songer, songer.getSRID());
//        System.out.println(integer);
    }

    @Test
    public void deleteSonger() {
//        System.out.println(singerService.deleteSingerInfo(14));
    }


}
