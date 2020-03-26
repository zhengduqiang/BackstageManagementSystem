package com.hhsj.BackstageManagementSystem.dao;

import com.hhsj.BackstageManagementSystem.pojo.BuiedgoodsCustom;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BuiedgoodsMapper {
    //查询全部
    List<BuiedgoodsCustom> selectAll(BuiedgoodsCustom bc);
    //根据ID删除
    int deleteById(int id);
    //根据ID查找
    BuiedgoodsCustom selectById(int id);
    //根据ID修改订单状态
    int updateState(Map map);
}