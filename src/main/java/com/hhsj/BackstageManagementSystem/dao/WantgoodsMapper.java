package com.hhsj.BackstageManagementSystem.dao;

import com.hhsj.BackstageManagementSystem.pojo.WantgoodsCustom;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("WantgoodsMapper")
public interface WantgoodsMapper {
    //    按条件查询
    List<WantgoodsCustom> selectWantGoodList(Map<String, String> map);

    //按ID删除
    int deleteWantGoodById(int id);

    int deleteWantgoodsMessage(int wid);

    int deleteMywantgood(int wid);

}