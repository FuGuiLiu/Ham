package com.sky.ham.service.impl;

import com.sky.ham.dao.SongerMapper;
import com.sky.ham.entity.Album;
import com.sky.ham.entity.Songer;
import com.sky.ham.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SongerMapper songerMapper;

    @Override
    public List<Songer> querySingersInfos(Songer songer, Integer startNo, Integer pageSize) {
        if (startNo < 1) {
            startNo = 1;
        }
        return songerMapper.querySingersInfos(songer, (startNo - 1) * pageSize, pageSize);
    }

    @Override
    public Integer querySingerCount(Songer songer) {
        return songerMapper.querySingerCount(songer);
    }

    @Override
    public Integer addSingerInfo(Songer songer) {
        return songerMapper.addSingerInfo(songer);
    }

    @Override
    public Integer deleteSingerInfo(Integer RSID) {
        return songerMapper.deleteSingerInfo(RSID);
    }

    @Override
    public Integer updateSingerInfo(Songer songer, Integer sRid) {
        return songerMapper.updateSingerInfo(songer, sRid);
    }

    @Override
    public Songer selectSingerInfo(Integer sRid) {
        return songerMapper.selectSingerInfo(sRid);
    }

    @Override
    public List<Songer> queryAllSingers() {
        return songerMapper.queryAllSingers();
    }

    @Override
    public Songer querySingerInfoBySID(Integer sID) {
        return songerMapper.querySingerInfoBySID(sID);
    }

}
