package com.hhsj.BackstageManagementSystem.dao;

import com.hhsj.BackstageManagementSystem.pojo.GoodsInfoCutom;
import com.hhsj.BackstageManagementSystem.pojo.Goodsinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsinfoMapper {
    /**
     * 查询审核商品的所有信息
     *
     * @return
     */
    List<GoodsInfoCutom> findGoodsInfoAll();

    /**
     * 按条件查询审核商品的信息
     *
     * @param goodsInfoCutom
     * @return
     */
    List<GoodsInfoCutom> findGoodsInfo(GoodsInfoCutom goodsInfoCutom);

    /**
     * 按id查看商品详情信息
     *
     * @param id
     * @return
     */
    GoodsInfoCutom findGoodsInfoId(GoodsInfoCutom id);

    /**
     * 审核商品信息
     *
     * @param goodsinfo
     * @return
     */
    int updateDisplay(Goodsinfo goodsinfo);

    //以下是订单列表相关的代码

    /**
     * 按条件查询订单列表
     *
     * @param goodsinfo
     * @return
     */
    List<Goodsinfo> findIndentList(Goodsinfo goodsinfo);

    /**
     * 查询所有
     *
     * @return
     */
    List<Goodsinfo> findIndentAll();

    /**
     * 按ID查询
     *
     * @param id
     * @return
     */
    Goodsinfo findById(int id);

    /**
     * 修改订单状态
     *
     * @param goodsinfo
     * @return
     */
    int UpdateGoodSale(Goodsinfo goodsinfo);

    /*以下是商品列表相关的代码*/
    //查询所有商品列表
    List<GoodsInfoCutom> findGoods(Map<String,Object> map);

    //查询商品总条数
    int findGoodCount(Map<String,Object> map);

    //查询单个商品信息
    GoodsInfoCutom findGoodById(@Param("id") int id);

    //修改商品信息
    int updateGood(GoodsInfoCutom cutom);

    //删除商品信息
    int delGood(@Param("id") int id);


}