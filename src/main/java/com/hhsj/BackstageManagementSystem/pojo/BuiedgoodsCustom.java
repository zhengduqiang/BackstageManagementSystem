package com.hhsj.BackstageManagementSystem.pojo;

/**
 * Created by JacksonYee on 2019/7/3.
 */
public class BuiedgoodsCustom extends Buiedgoods {
    private Goodsinfo goodsinfo;
    private Userinfo uUser;
    private Userinfo gUser;
    private String goodName;
    private Integer goodType;
    private double tradingValue;
    private String buyName;
    private String saleName;
    private int transaction;

    public Goodsinfo getGoodsinfo() {
        return goodsinfo;
    }

    public void setGoodsinfo(Goodsinfo goodsinfo) {
        this.goodsinfo = goodsinfo;
    }

    public Userinfo getuUser() {
        return uUser;
    }

    public void setuUser(Userinfo uUser) {
        this.uUser = uUser;
    }

    public Userinfo getgUser() {
        return gUser;
    }

    public void setgUser(Userinfo gUser) {
        this.gUser = gUser;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public double getTradingValue() {
        return tradingValue;
    }
    public void setTradingValue(double price) {
        this.tradingValue = price;
    }

    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }
}
