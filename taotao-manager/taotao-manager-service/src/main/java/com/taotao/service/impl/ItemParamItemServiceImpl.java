package com.taotao.service.impl;

import com.taotao.common.Utils.JsonUtils;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ItemParamItemServiceImpl
 * @Description TODO
 * @Author 陈刀仔
 * @Date 2020/3/10 下午2:35
 * @Version 1.0
 */

@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

    @Autowired
    private TbItemParamItemMapper mapper;

    @Override
    public String showItemParam(Long showIPid) {
        //查询条件
        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(showIPid);
        //执行查询
        List<TbItemParamItem> list = mapper.selectByExampleWithBLOBs(example);
        if (list == null || list.size() == 0) {
            return "";
        }
        //取出规格参数信息
        TbItemParamItem itemParamItem = list.get(0);
        String paramData = itemParamItem.getParamData();
        System.out.println(paramData);
        //生成html
        List<Map> groupList = JsonUtils.jsonToList(paramData, Map.class);
        StringBuffer sb = new StringBuffer();
        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
        sb.append("    <tbody>\n");
        for(Map m1:groupList) {
            sb.append("        <tr>\n");
            sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
            sb.append("        </tr>\n");
            List<Map> paramList = (List<Map>) m1.get("params");
            for(Map m2:paramList) {
                sb.append("        <tr>\n");
                sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
                sb.append("            <td>"+m2.get("v")+"</td>\n");
                sb.append("        </tr>\n");
            }
        }
        sb.append("    </tbody>\n");
        sb.append("</table>");

        return sb.toString();
    }
}
