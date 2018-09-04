package indi.goddess.shoppingmall2.service.manager.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.dao.manager.GoodsDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.manager.TbGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbGoodsServiceImpl implements TbGoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbGoods> page= (Page<TbGoods>) goodsDao.findAllGood();
        return new PageResult(page.getTotal(),page.getResult());
    }

    public void updateStatus(Long[] ids, String status) {
        for(Long id:ids){
            TbGoods goods =  goodsDao.selectByPrimaryKey(id);
            goods.setAuditStatus(status);
            System.out.println(">>>>>>>"+goods+">>>>>>>>");
            goodsDao.updateByPrimaryKey(goods);
        }
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            TbGoods goods = goodsDao.selectByPrimaryKey(id);
            goods.setIsDelete("1");
            goodsDao.updateByPrimaryKey(goods);
        }
    }

    @Override
    public PageResult findPageByCondition(TbGoods good, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbGoods> list=goodsDao.findByCondition(good);
        Page<TbGoods> page= (Page<TbGoods>) list;
        return new PageResult(page.getTotal(), page.getResult());

    }
}
