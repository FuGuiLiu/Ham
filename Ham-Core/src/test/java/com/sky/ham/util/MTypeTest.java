package com.sky.ham.util;

import com.sky.ham.entity.MType;
import com.sky.ham.service.MTypeService;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class MTypeTest {
    @Test
    public void getConnTest() {
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
    }

    @Test
    public void paginationTest() {
        MTypeService mTypeService = (MTypeService) BeanUtils.getBean("mTypeServiceImpl");
        List<MType> mTypes = mTypeService.queryMTypesAndPagination(-1, 5, "电");
        for (MType mType : mTypes) {
            System.out.println(mType.toString());
        }
    }

    @Test
    public void mTypeCountQuery() {
        MTypeService mTypeService = (MTypeService) BeanUtils.getBean("mTypeServiceImpl");
        int i = mTypeService.queryMTypesCount("电");
        System.out.println(i);
    }

    @Test
    public void mTypeInsert() {
        MTypeService mTypeService = (MTypeService) BeanUtils.getBean("mTypeServiceImpl");
//        int i = mTypeService.insertMType(new MType(null, "富贵", "刘富贵"));
//        System.out.println(i);
    }

    @Test
    public void mTypeUpdate() {
        MTypeService mTypeService = (MTypeService) BeanUtils.getBean("mTypeServiceImpl");
//        int i = mTypeService.updateMTypes(22, new MType(null, "富贵", "刘富贵aa"));
//        System.out.println(i);
    }

    @Test
    public void mTypeDelete() {
        MTypeService mTypeService = (MTypeService) BeanUtils.getBean("mTypeServiceImpl");
//        int i = mTypeService.deleteMType(22);
//        System.out.println(i);
    }

    @Test
    public void tests() {
        MTypeService mTypeService = (MTypeService) BeanUtils.getBean("mTypeServiceImpl");
        List<MType> mTypes = mTypeService.queryMTypeInfos();
        for (MType mType : mTypes) {
            System.out.println(mType.toString());
        }
    }
}
