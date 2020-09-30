package com.sky.ham.service.impl;

import com.sky.ham.dao.SongMapper;
import com.sky.ham.dao.SongerMapper;
import com.sky.ham.entity.Album;
import com.sky.ham.entity.Song;
import com.sky.ham.service.SongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class SongServiceImpl implements SongService {
    @Resource
    private SongMapper songMapper;

    @Override
    public List<Song> querySongInfos(Song song, Integer startNo, Integer pageSize) {
        if (startNo < 1) {
            startNo = 1;
        }
        return songMapper.querySongInfos(song, (startNo - 1) * pageSize, pageSize);
    }

    @Override
    public Integer querySongCounts(Song song) {
        return songMapper.querySongCount(song);
    }

    @Override
    public Integer addSong(Song song) {
        return songMapper.addSong(song);
    }

    @Override
    public Integer deleteSong(Integer sid) {
        return songMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public Integer updateSong(Song song) {
        return songMapper.updateSongInfo(song);
    }

    @Override
    public Song querySongInfo(Integer SID) {
        return songMapper.querySongInfo(SID);
    }

    @Override
    public List<Song> querySongInfosByAID(Integer AID) {
        return songMapper.querySongInfosByAID(AID);
    }

    @Override
    public List<Song> querySongsInfosByIDS(List<Integer> ids) {
        return songMapper.querySongsInfosByIDS(ids);
    }
}
