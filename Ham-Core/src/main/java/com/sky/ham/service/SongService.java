package com.sky.ham.service;

import com.sky.ham.entity.Album;
import com.sky.ham.entity.Song;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface SongService {
    /**
     * 查询歌手信息
     *
     * @param song
     * @param startNo
     * @param pageSize
     * @return
     */
    List<Song> querySongInfos(Song song, Integer startNo, Integer pageSize);

    /**
     * 查询歌手信息
     *
     * @param SID
     * @return
     */
    Song querySongInfo(Integer SID);

    /**
     * 查询信息数量
     *
     * @param song
     * @return
     */
    Integer querySongCounts(Song song);

    /**
     * 添加音乐
     *
     * @param song
     * @return
     */
    Integer addSong(Song song);

    /**
     * 删除歌曲
     *
     * @param sid
     * @return
     */
    Integer deleteSong(Integer sid);

    /**
     * 更新歌曲
     *
     * @param song
     * @return
     */
    Integer updateSong(Song song);

    /**
     * 查询歌曲信息根据媒体类型
     *
     * @param AID
     * @return
     */
    List<Song> querySongInfosByAID(Integer AID);

    /**
     * 查询歌曲信息根据歌曲id
     *
     * @param ids
     * @return
     */
    List<Song> querySongsInfosByIDS(List<Integer> ids);
}
