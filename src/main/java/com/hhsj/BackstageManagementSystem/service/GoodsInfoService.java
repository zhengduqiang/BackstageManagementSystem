package com.hhsj.BackstageManagementSystem.service;

import com.hhsj.BackstageManagementSystem.dao.GoodsinfoMapper;
import com.hhsj.BackstageManagementSystem.pojo.GoodsInfoCutom;
import com.hhsj.BackstageManagementSystem.pojo.Goodsinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XiaoDu on 2019/6/30.
 */
@Service
public class GoodsInfoService {
    @Resource
    private GoodsinfoMapper goodsinfoMapper;

    /**
     * 查询所有审核商品信息
     *
     * @return
     */
    public List<GoodsInfoCutom> findGoodsInfoAll() {
        List<GoodsInfoCutom> goodsInfoAll = goodsinfoMapper.findGoodsInfoAll();
        return goodsInfoAll;
    }

    /**
     * 按条件查询审核商品信息
     *
     * @param goodsInfoCutom
     * @return
     */
    public List<GoodsInfoCutom> findGoodsInfo(GoodsInfoCutom goodsInfoCutom) {
        List<GoodsInfoCutom> goodsInfo = goodsinfoMapper.findGoodsInfo(goodsInfoCutom);
        return goodsInfo;
    }

    /**
     * 按ID查看商品详情信息
     *
     * @param id
     * @return
     */
    public GoodsInfoCutom findGoodsInfoId(GoodsInfoCutom id) {
        GoodsInfoCutom goodsInfoId = goodsinfoMapper.findGoodsInfoId(id);
        return goodsInfoId;
    }

    /**
     * 审核商品信息
     *
     * @param goodsinfo
     * @return
     */
    public int updateDisplay(Goodsinfo goodsinfo) {
        int i = goodsinfoMapper.updateDisplay(goodsinfo);
        return i;
    }

    /**
     * 按条件查询订单列表
     *
     * @param goodsinfo
     * @return
     */
    public List<Goodsinfo> findIndentList(Goodsinfo goodsinfo) {
        return goodsinfoMapper.findIndentList(goodsinfo);
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<Goodsinfo> findIndentAll() {
        return goodsinfoMapper.findIndentAll();
    }

    /**
     * 按ID查询
     *
     * @param id
     * @return
     */
    public Goodsinfo findById(int id) {
        return goodsinfoMapper.findById(id);
    }

    /**
     * 修改订单状态
     *
     * @param goodsinfo
     * @return
     */
    public int UpdateGoodSale(Goodsinfo goodsinfo) {
        return goodsinfoMapper.UpdateGoodSale(goodsinfo);
    }

    /*以下是商品列表相关的代码*/

    public List<GoodsInfoCutom> findGoods(int display, int type, String name, int pageNum, int pageSize) {
        int pageIndex = (pageNum - 1) * pageSize;
        Map<String,Object> map = new HashMap<>();
        map.put("display",display);
        map.put("type",type);
        map.put("name",name);
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        return goodsinfoMapper.findGoods(map);
    }


    public int findGoodCount(int display,int type,String name) {
        Map<String,Object> map = new HashMap<>();
        map.put("display",display);
        map.put("type",type);
        map.put("name",name);
        return goodsinfoMapper.findGoodCount(map);
    }

    public GoodsInfoCutom findGoodById(int id) {
        return goodsinfoMapper.findGoodById(id);
    }

    public int updateGood(GoodsInfoCutom custom) {
        return goodsinfoMapper.updateGood(custom);
    }

    public int delGood(int id) {
        return goodsinfoMapper.delGood(id);
    }

}
