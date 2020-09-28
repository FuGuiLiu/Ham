package com.sky.ham.service;

import com.sky.ham.entity.Song;
import com.sky.ham.entity.Songer;

import java.util.List;

/**
 * @author Administrator
 */
public interface SingerService {
    /**
     * 歌手信息查询
     *
     * @param songer
     * @param startNo
     * @param pageSize
     * @return
     */
    List<Songer> querySingersInfos(Songer songer, Integer startNo, Integer pageSize);

    /**
     * 查询内容
     *
     * @param songer
     * @return
     */
    Integer querySingerCount(Songer songer);

    /**
     * 添加歌手
     *
     * @param songer
     * @return
     */
    Integer addSingerInfo(Songer songer);

    /**
     * 删除歌手信息
     *
     * @param RSID
     * @return
     */
    Integer deleteSingerInfo(Integer RSID);

    /**
     * 更新歌手信息
     *
     * @param songer
     * @param sRid
     * @return
     */
    Integer updateSingerInfo(Songer songer, Integer sRid);

    /**
     * 查询歌手信息
     *
     * @param sRid
     * @return
     */
    Songer selectSingerInfo(Integer sRid);

    /**
     * 查询所有的歌手信息
     *
     * @return
     */
    List<Songer> queryAllSingers();

    /**
     * 查询歌手信息根据歌手的ID
     *
     * @param sID
     * @return
     */
    Songer querySingerInfoBySID(Integer sID);
}
