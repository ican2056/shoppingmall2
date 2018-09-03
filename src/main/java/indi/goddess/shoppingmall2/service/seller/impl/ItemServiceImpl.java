package indi.goddess.shoppingmall2.service.seller.impl;

import indi.goddess.shoppingmall2.beans.TbItem;
import indi.goddess.shoppingmall2.dao.seller.TbItemDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.seller.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemDao tbItemDao;
    @Override
    public List<TbItem> findAll() {
        return tbItemDao.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return tbItemDao.findPage(pageNum,pageSize);
    }

    @Override
    public void add(TbItem item) {
        tbItemDao.add(item);
    }

    @Override
    public void update(TbItem item) {
        tbItemDao.update(item);
    }

    @Override
    public TbItem findOne(Long id) {
        return tbItemDao.findOne(id);
    }

    @Override
    public void delete(Long[] ids) {
        tbItemDao.delete(ids);
    }

    @Override
    public PageResult findPage(TbItem item, int pageNum, int pageSize) {
        return tbItemDao.findPage(item,pageNum,pageSize);
    }
}
