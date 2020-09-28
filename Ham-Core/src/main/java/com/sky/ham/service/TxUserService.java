package com.sky.ham.service;

import com.sky.ham.entity.TxUser;

/**
 * @author Administrator
 */
public interface TxUserService {
    /**
     * 用户登录
     *
     * @param txUser
     * @return
     */
    TxUser queryLogin(TxUser txUser);
}
