package indi.goddess.shoppingmall2.service.seller.impl;

import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.beans.TbItem;
import indi.goddess.shoppingmall2.beans.group.Goods;
import indi.goddess.shoppingmall2.dao.seller.TbGoodsDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.seller.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private TbGoodsDao tbGoodsDao;
    @Override
    public List<TbGoods> findAll() {
        return tbGoodsDao.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return tbGoodsDao.findPage(pageNum,pageSize);
    }

    @Override
    public void add(Goods goods) {

    }

    @Override
    public void update(Goods goods) {

    }

    @Override
    public Goods findOne(Long id) {
        return tbGoodsDao.findOne(id);
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void updateStatus(Long[] ids, String status) {

    }

    @Override
    public List<TbItem> findItemListByGoodsIdListAndStatus(Long[] goodsIds, String status) {
        return null;
    }
}
