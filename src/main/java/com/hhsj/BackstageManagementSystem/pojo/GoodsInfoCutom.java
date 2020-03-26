package com.hhsj.BackstageManagementSystem.pojo;

/**
 * Created by XiaoDu on 2019/6/30.
 */
public class GoodsInfoCutom extends Goodsinfo {
    private Goodstype goodstype;//商品类型
    private Userinfo userinfo;//用户信息


    public Goodstype getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(Goodstype goodstype) {
        this.goodstype = goodstype;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }
}
