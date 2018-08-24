package indi.goddess.shoppingmall2.service.merchant.impl;

import indi.goddess.shoppingmall2.beans.TbItemCat;
import indi.goddess.shoppingmall2.dao.merchant.TbItemCatDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.merchant.ItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Resource(name="tbItemCatDaoImpl")
    private TbItemCatDao tbItemCatDao;
    @Override
    public List<TbItemCat> findAll() {
        return tbItemCatDao.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return tbItemCatDao.findPage(pageNum,pageSize);
    }

    @Override
    public void add(TbItemCat itemCat) {
        tbItemCatDao.add(itemCat);
    }

    @Override
    public void update(TbItemCat itemCat) {
        tbItemCatDao.update(itemCat);
    }

    @Override
    public TbItemCat findOne(Long id) {
        return tbItemCatDao.findOne(id);
    }

    @Override
    public void delete(Long[] ids) {
        tbItemCatDao.delete(ids);
    }

    @Override
    public PageResult findPage(TbItemCat itemCat, int pageNum, int pageSize) {
        return tbItemCatDao.findPage(itemCat,pageNum,pageSize);
    }

    @Override
    public List<TbItemCat> findByParentId(Long parentId) {
        return tbItemCatDao.findByParentId(parentId);
    }
}
