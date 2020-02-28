package com.taotao.service;

import com.taotao.commom.pojo.EUTreeNode;

import java.util.List;

/**
 * @ClassName ItemCatService
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/2/28 9:28
 * @Version 1.0
 */
public interface ItemCatService {
    List<EUTreeNode> getItemCatList(long parentid);
}
