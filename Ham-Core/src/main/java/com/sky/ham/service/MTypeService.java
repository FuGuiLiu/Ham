package com.sky.ham.service;

import com.sky.ham.entity.MType;

import java.util.List;

/**
 * @author Administrator
 */
public interface MTypeService {
    /**
     * 查询媒体类型根据条件分页
     *
     * @param startNo
     * @param pageSize
     * @param fuzzyName
     * @return
     */
    List<MType> queryMTypesAndPagination(Integer startNo, Integer pageSize, String fuzzyName);

    /**
     * 查询媒体的数量,或根据名称查询媒体数量
     *
     * @param TName
     * @return
     */
    int queryMTypesCount(String TName);

    /**
     * 新增媒体信息
     *
     * @param mType
     * @return
     */
    int insertMType(MType mType);

    /**
     * 删除媒体信息
     *
     * @param tid
     * @return
     */
    int deleteMType(Integer tid);

    /**
     * 更新媒体
     *
     * @param tid
     * @param mType
     * @return
     */
    int updateMTypes(Integer tid, MType mType);

    /**
     * 查询媒体类型
     *
     * @param tid
     * @return
     */
    MType queryMType(Integer tid);

    /**
     * 查询所有的媒体信息
     *
     * @return
     */
    List<MType> queryMTypeInfos();
}
