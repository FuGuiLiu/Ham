package com.sky.ham.dao;

import com.sky.ham.entity.Album;
import com.sky.ham.entity.Song;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface SongMapper {
    int deleteByPrimaryKey(Integer SID);

    int addSong(Song record);

    Song selectByPrimaryKey(Integer SID);

    /**
     * 更新歌曲信息
     *
     * @param song
     * @return
     */
    Integer updateSongInfo(Song song);

    /**
     * 查询歌手信息,根据条件
     *
     * @return
     */
    List<Song> querySongInfos(@Param(value = "paramSong") Song song, @Param("paramStartNo") Integer startNo, @Param("paramPageSize") Integer pageSize);

    /**
     * 根据条件查询歌曲数量
     *
     * @param song
     * @return
     */
    Integer querySongCount(@Param(value = "paramSong") Song song);

    /**
     * 查询音乐信息
     *
     * @param SID
     * @return
     */
    Song querySongInfo(@Param(value = "paramSid") Integer SID);

    /**
     * 查询歌曲信息根据专辑id
     *
     * @param AID
     * @return
     */
    List<Song> querySongInfosByAID(@Param("paramAID") Integer AID);

    List<Song> querySongsInfosByIDS(@Param("pramIds") List<Integer> ids);
}