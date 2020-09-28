package com.sky.ham.service.impl;

import com.sky.ham.dao.TxUserMapper;
import com.sky.ham.entity.TxUser;
import com.sky.ham.service.TxUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class TxUserServiceImpl implements TxUserService {
    @Resource
    private TxUserMapper txUserMapper;

    @Override
    public TxUser queryLogin(TxUser txUser) {
        return txUserMapper.queryLogin(txUser);
    }
}
