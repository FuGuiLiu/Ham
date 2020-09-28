package com.sky.ham.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    //总页数
    private int pageCount;
    //每页显示的信息数量
    private int pageSize = 5;
    //信息总个数
    private int totalCount;
    //当前页数
    private int currentPage = 0;

    public int getPageCount() {
        if (this.totalCount % this.pageSize == 0) {
            this.pageCount = this.totalCount / this.pageSize;
        } else if (this.totalCount % this.pageSize != 0) {
            this.pageCount = this.getTotalCount() / this.getPageSize() + 1;
        }
        return pageCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount < 0) {
            totalCount = 0;
        }
        this.totalCount = totalCount;
    }
}
