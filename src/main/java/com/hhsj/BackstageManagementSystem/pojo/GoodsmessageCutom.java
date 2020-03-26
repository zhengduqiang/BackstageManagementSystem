package com.hhsj.BackstageManagementSystem.pojo;

/**
 * Created by XiaoDu on 2019/7/3.
 */
public class GoodsmessageCutom extends Goodsmessage {
    private Userinfo userinfo;//用户表
    private Goodsinfo goodsinfo;//商品表
    private Integer type;//用于分页查询
    private String name;//用法分页查询

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public Goodsinfo getGoodsinfo() {
        return goodsinfo;
    }

    public void setGoodsinfo(Goodsinfo goodsinfo) {
        this.goodsinfo = goodsinfo;
    }
}
