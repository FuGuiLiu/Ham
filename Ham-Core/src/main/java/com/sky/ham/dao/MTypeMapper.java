package com.sky.ham.dao;

import com.sky.ham.entity.MType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface MTypeMapper {

    /**
     * @param record
     * @return
     */
    int newMTypeInsert(@Param("paramRecord") MType record);

    /**
     * 删除媒体类型根据id
     *
     * @param tid
     * @return
     */
    int MTypeDeleteById(@Param("paramTID") Integer tid);

    /**
     * @param tid
     * @return
     */
    int byPrimaryUpdate(@Param("paramTID") Integer tid, @Param("paramMType") MType mType);


    /**
     * 查询类型并分页
     *
     * @param startNo
     * @param pageSize
     * @return
     */
    List<MType> mTypesQueryAndPagination(@Param("paramStartNo") Integer startNo, @Param("paramPageSize") Integer pageSize, @Param("paramTName") String TName);

    /**
     * @param TName
     * @return
     */
    int mTypesCountQuery(@Param("paramTName") String TName);

    /**
     * 根据id查询媒体类型
     *
     * @param tid
     * @return
     */
    MType mTypeByIdQuery(@Param("paramTID") Integer tid);

    /**
     * 查询所有的媒体信息
     *
     * @return
     */
    List<MType> queryMTypeInfo();
}