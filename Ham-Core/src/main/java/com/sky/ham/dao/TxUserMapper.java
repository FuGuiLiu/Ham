package com.sky.ham.dao;

import com.sky.ham.entity.TxUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
public interface TxUserMapper {

    int deleteByPrimaryKey(Integer USER_ID);

    int insert(TxUser record);

    int insertSelective(TxUser record);

    TxUser selectByPrimaryKey(Integer USER_ID);

    int updateByPrimaryKeySelective(TxUser record);

    int updateByPrimaryKey(TxUser record);
    /**
     * 用户登录
     *
     * @param txUser
     * @return
     */
    TxUser queryLogin(@Param("txUser") TxUser txUser);
}