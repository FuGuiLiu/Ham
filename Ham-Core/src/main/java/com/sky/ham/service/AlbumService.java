package com.sky.ham.service;

import com.sky.ham.entity.Album;

import java.util.List;

/**
 * @author Administrator
 */
public interface AlbumService {
    /**
     * 查询专辑信息并分页
     *
     * @param album
     * @param startNo
     * @param pageSize
     * @return
     */
    List<Album> queryAlbumInfos(Album album, Integer startNo, Integer pageSize);

    /**
     * 根据条件查询专辑数量
     *
     * @param album
     * @return
     */
    Integer queryAlbumCount(Album album);

    /**
     * 添加专辑信息
     *
     * @param album
     * @return
     */
    Integer addAlbumInfo(Album album);

    /**
     * 删除专辑信息
     *
     * @param aId
     * @return
     */
    Integer deleteAlbumInfo(Integer aId);

    /**
     * 更新专辑信息
     *
     * @param album
     * @param aId
     * @return
     */
    Integer updateAlbumInfo(Album album, Integer aId);

    /**
     * 查询名称是否存在
     *
     * @param name
     * @return
     */
    Integer queryANameExists(String name);

    /**
     * 查询所有的专辑
     *
     * @return
     */
    List<Album> queryAllAlbumInfos();

    /**
     * 查询媒体信息根据id
     *
     * @param aId
     * @return
     */
    Album queryAlbumInfoByAID(Integer aId);
}
