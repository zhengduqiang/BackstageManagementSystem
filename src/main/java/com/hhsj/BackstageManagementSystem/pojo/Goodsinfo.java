package com.hhsj.BackstageManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Goodsinfo {
    private Integer id;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date modify;

    private String name;

    private Integer level;

    private String remark;

    private Short tradingValue;

    private Integer type;

    private Integer count;

    private Integer display;

    private Integer transaction;

    private Integer truePrice;

    private Integer uid;
    private Integer view;

    private String image;

    public String getImage1() {
        return image1;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    private String image1;

    private String image2;

    private String image3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getModify() {
        return modify;
    }

    public void setModify(Date modify) {
        this.modify = modify;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Short getTradingValue() {
        return tradingValue;
    }

    public void setTradingValue(Short tradingValue) {
        this.tradingValue = tradingValue;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getTransaction() {
        return transaction;
    }

    public void setTransaction(Integer transaction) {
        this.transaction = transaction;
    }

    public Integer getTruePrice() {
        return truePrice;
    }

    public void setTruePrice(Integer truePrice) {
        this.truePrice = truePrice;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}