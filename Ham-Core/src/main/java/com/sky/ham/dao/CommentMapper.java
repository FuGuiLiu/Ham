package com.sky.ham.dao;

import com.sky.ham.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer COMMENT_ID);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer COMMENT_ID);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}