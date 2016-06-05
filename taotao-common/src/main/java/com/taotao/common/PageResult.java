package com.taotao.common;

import java.util.List;

/**
 * 分页返回结果
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
public class PageResult {
   // 分页总数
    private long total;
    // 分页列表
    private List rows;

    public long getTotal() {
        return total;
    }

    public PageResult setTotal(long total) {
        this.total = total;
        return  this;
    }

    public List getRows() {
        return rows;
    }

    public PageResult setRows(List rows) {
        this.rows = rows;
        return this;
    }
}
