package com.taotao.service;

import com.taotao.commom.pojo.EUDataGridResult;
import com.taotao.commom.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * @ClassName ItemParamService
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/8 下午8:39
 * @Version 1.0
 */
public interface ItemParamService {
    TaotaoResult getParamCid(long cid);
    TaotaoResult insertIemParam(TbItemParam itemParam);
    EUDataGridResult getItemParamList(int page,int rows);
}
