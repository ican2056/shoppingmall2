package indi.goddess.shoppingmall2.dao.seller.impl;

import indi.goddess.shoppingmall2.beans.TbItem;
import indi.goddess.shoppingmall2.dao.seller.TbItemDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbItemDaoImpl implements TbItemDao {
    @Override
    public List<TbItem> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void add(TbItem item) {

    }

    @Override
    public void update(TbItem item) {

    }

    @Override
    public TbItem findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public PageResult findPage(TbItem item, int pageNum, int pageSize) {
        return null;
    }
}
