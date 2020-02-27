package com.taotao.commom.pojo;/**
 * Create by 陈刀仔 at 18:45 on 2020/2/27
 */

import java.util.List;

/**
 *@ClassName EUDataGridResult
 *@Description TODO
 *@Author 陈刀仔
 *@Date 2020/2/27 18:45
 *@Version 1.0
 */
public class EUDataGridResult {

    private int total;
    private List<?> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
