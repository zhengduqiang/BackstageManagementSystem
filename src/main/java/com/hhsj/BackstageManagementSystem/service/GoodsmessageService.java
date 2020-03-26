package com.hhsj.BackstageManagementSystem.service;

import com.hhsj.BackstageManagementSystem.dao.GoodsmessageMapper;
import com.hhsj.BackstageManagementSystem.pojo.GoodsmessageCutom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by XiaoDu on 2019/7/3.
 */
@Service
public class GoodsmessageService {
    @Resource
    private GoodsmessageMapper goodsmessageMapper;

    public List<GoodsmessageCutom> findGoodsMessageList() {
        List<GoodsmessageCutom> goodsMessageList = goodsmessageMapper.findGoodsMessageList();
        return goodsMessageList;
    }

    /**
     * 条件查询
     *
     * @param goodsmessageCutom
     * @return
     */
    public List<GoodsmessageCutom> findGoodsMessage(GoodsmessageCutom goodsmessageCutom) {
        List<GoodsmessageCutom> goodsMessage = goodsmessageMapper.findGoodsMessage(goodsmessageCutom);
        return goodsMessage;
    }

    public int deleteGoodsMessageId(Integer id) {
        int i = goodsmessageMapper.deleteGoodsMessageId(id);
        return i;

    }
}
