package com.hhsj.BackstageManagementSystem.dao;

import com.hhsj.BackstageManagementSystem.pojo.GoodsmessageCutom;

import java.util.List;

public interface GoodsmessageMapper {
    /**
     * 查询所有用户发布的评论信息
     * @return
     */
    List<GoodsmessageCutom> findGoodsMessageList();

    /**
     * 按条件查询用户发布的评论信息
     * @param goodsmessageCutom
     * @return
     */
    List<GoodsmessageCutom> findGoodsMessage(GoodsmessageCutom goodsmessageCutom);

    /**
     * 删除用户评论的信息
     * @param id
     * @return
     */
    int deleteGoodsMessageId(Integer id);
}