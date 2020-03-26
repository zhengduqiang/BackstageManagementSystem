package com.hhsj.BackstageManagementSystem.service;


import com.hhsj.BackstageManagementSystem.dao.WantgoodsMapper;
import com.hhsj.BackstageManagementSystem.pojo.WantgoodsCustom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by JacksonYee on 2019/7/2.
 */
@Service("WantGoodsService")
public class WantGoodsService {
    @Resource(name = "WantgoodsMapper")
    WantgoodsMapper wantgoodsMapper;

    //    按条件查询
    public List<WantgoodsCustom> selectWantGoodList(Map<String, String> map) {
        return wantgoodsMapper.selectWantGoodList(map);
    }

    //    按ID删除
    public int deleteWantGoodById(int id) {
        return wantgoodsMapper.deleteWantGoodById(id);
    }

    public int deleteWantgoodsMessage(int wid) {
        return wantgoodsMapper.deleteWantgoodsMessage(wid);

    }

    public int deleteMywantgood(int wid) {
        return wantgoodsMapper.deleteMywantgood(wid);
    }
}
