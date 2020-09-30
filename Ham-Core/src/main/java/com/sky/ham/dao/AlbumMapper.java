package com.sky.ham.dao;

import com.sky.ham.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface AlbumMapper {

    /**
     * 根据条件查询专辑的信息
     *
     * @param album
     * @return
     */
    List<Album> queryAlbumInfos(@Param("paramAlbum") Album album, @Param("paramStartNo") Integer startNo, @Param("paramPageSize") Integer pageSize);

    /**
     * 专辑的页数查询
     *
     * @param album
     * @return
     */
    Integer queryAlbumCount(@Param("paramAlbum") Album album);

    /**
     * 添加专辑
     *
     * @param album
     * @return
     */
    Integer addAlbumInfo(@Param("paramAlbum") Album album);

    /**
     * 删除专辑
     *
     * @param aid
     * @return
     */
    Integer deleteAlbumInfo(@Param("paramAid") Integer aid);

    /**
     * 更新专辑
     *
     * @param album
     * @param aid
     * @return
     */
    Integer updateAlbumInfo(@Param("paramAlbum") Album album, @Param("paramAid") Integer aid);

    /**
     * 根据名称查询名称是否存在
     *
     * @param name
     * @return
     */
    Integer queryNameExists(@Param("paramName") String name);

    /**
     * 查询所有的专辑
     *
     * @return
     */
    List<Album> queryAllAlbumInfos();

    Album queryAlbumInfoByAID(Integer aID);

    /**
     * 查询专辑信息根据专辑名称
     *
     * @param fuzzyName
     * @return
     */
    List<Album> queryAlbumInfoByName(@Param(value = "paramFuzzyName") String fuzzyName);
}