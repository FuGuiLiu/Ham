package com.sky.ham.service.impl;

import com.sky.ham.dao.AlbumMapper;
import com.sky.ham.entity.Album;
import com.sky.ham.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 */
@Service("albumServiceImpl")
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;


    @Override
    @Transactional(readOnly = true)
    public List<Album> queryAlbumInfos(Album album, Integer startNo, Integer pageSize) {
        if (startNo < 1) {
            startNo = 1;
        }
        return albumMapper.queryAlbumInfos(album, (startNo - 1) * pageSize, pageSize);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer queryAlbumCount(Album album) {
        return albumMapper.queryAlbumCount(album);
    }

    @Override
    public Integer addAlbumInfo(Album album) {
        return albumMapper.addAlbumInfo(album);
    }

    @Override
    public Integer deleteAlbumInfo(Integer aId) {
        return albumMapper.deleteAlbumInfo(aId);
    }

    @Override
    public Integer updateAlbumInfo(Album album, Integer aId) {
        return albumMapper.updateAlbumInfo(album, aId);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer queryANameExists(String name) {
        return albumMapper.queryNameExists(name);
    }

    @Override
    public List<Album> queryAllAlbumInfos() {
        return albumMapper.queryAllAlbumInfos();
    }

    @Override
    public Album queryAlbumInfoByAID(Integer aId) {
        return albumMapper.queryAlbumInfoByAID(aId);
    }

    @Override
    public List<Album> queryAlbumByFuzzyName(String fuzzyName) {
        return albumMapper.queryAlbumInfoByName(fuzzyName);
    }
}
