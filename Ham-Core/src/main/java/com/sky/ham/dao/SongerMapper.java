package com.sky.ham.dao;

import com.sky.ham.entity.Songer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */

public interface SongerMapper {
    /**
     * 根据条件查询歌手的信息
     *
     * @param songer
     * @return
     */
    List<Songer> querySingersInfos(@Param("paramSinger") Songer songer, @Param("paramStartNo") Integer startNo, @Param("paramPageSize") Integer pageSize);

    /**
     * 专辑的页数查询
     *
     * @param songer
     * @return
     */
    Integer querySingerCount(@Param("paramSinger") Songer songer);

    /**
     * 添加专辑
     *
     * @param songer
     * @return
     */
    Integer addSingerInfo(@Param("paramSinger") Songer songer);

    /**
     * 删除专辑
     *
     * @param sRid
     * @return
     */
    Integer deleteSingerInfo(@Param("paramSRid") Integer sRid);

    /**
     * 更新专辑
     *
     * @param songer
     * @param sRid
     * @return
     */
    Integer updateSingerInfo(@Param("paramSinger") Songer songer, @Param("paramSRid") Integer sRid);

    /**
     * 查询歌手信息
     *
     * @param sRid
     * @return
     */
    Songer selectSingerInfo(@Param("paramSRid") Integer sRid);

    /**
     * 查询所有的歌手
     *
     * @return
     */
    List<Songer> queryAllSingers();

    /**
     * 查询歌手信息根据歌手id
     *
     * @param sID
     * @return
     */
    Songer querySingerInfoBySID(@Param("paramSID") Integer sID);
}