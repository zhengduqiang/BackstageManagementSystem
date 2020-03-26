package com.hhsj.BackstageManagementSystem.service;

import com.hhsj.BackstageManagementSystem.dao.BuiedgoodsMapper;
import com.hhsj.BackstageManagementSystem.pojo.BuiedgoodsCustom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by JacksonYee on 2019/7/3.
 */
@Service
public class BuiedgoodsService {
    @Resource
    BuiedgoodsMapper buiedgoodsMapper;

    //查询全部
    public List<BuiedgoodsCustom> selectAll(BuiedgoodsCustom bc ){
        return buiedgoodsMapper.selectAll(bc);
    }
    //根据ID删除
    public int deleteById(int id){
        return buiedgoodsMapper.deleteById(id);
    }
    //根据ID查找
    public BuiedgoodsCustom selectById(int id){
        return buiedgoodsMapper.selectById(id);
    }
    //根据ID修改订单状态
    public int updateState(Map map){return buiedgoodsMapper.updateState(map);}
}
