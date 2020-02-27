package com.taotao.service;

import com.taotao.commom.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * Create by 陈刀仔 at 23:21 on 2020/2/21
 */
public interface ItemService {
    TbItem getItemById(Long itemId);

    EUDataGridResult getItemList(int page, int rows);
}
