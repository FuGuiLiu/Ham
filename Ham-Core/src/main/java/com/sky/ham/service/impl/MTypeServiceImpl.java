package com.sky.ham.service.impl;

import com.sky.ham.dao.MTypeMapper;
import com.sky.ham.entity.MType;
import com.sky.ham.service.MTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service(value = "mTypeServiceImpl")
public class MTypeServiceImpl implements MTypeService {

    @Resource
    private MTypeMapper mTypeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MType> queryMTypesAndPagination(Integer startNo, Integer pageSize, String fuzzyName) {
        if (startNo < 1) {
            startNo = 1;
        }
        return mTypeMapper.mTypesQueryAndPagination((startNo - 1) * pageSize, pageSize, fuzzyName);
    }

    @Override
    public int queryMTypesCount(String TName) {
        return mTypeMapper.mTypesCountQuery(TName);
    }

    @Override
    public int insertMType(MType mType) {
        return mTypeMapper.newMTypeInsert(mType);
    }

    @Override
    public int deleteMType(Integer tid) {
        return mTypeMapper.MTypeDeleteById(tid);
    }

    @Override
    public int updateMTypes(Integer tid, MType mType) {
        return mTypeMapper.byPrimaryUpdate(tid, mType);
    }

    @Override
    public MType queryMType(Integer tid) {
        return mTypeMapper.mTypeByIdQuery(tid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MType> queryMTypeInfos() {
        return mTypeMapper.queryMTypeInfo();
    }
}
