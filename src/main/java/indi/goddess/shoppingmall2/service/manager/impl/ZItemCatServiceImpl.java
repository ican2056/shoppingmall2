package indi.goddess.shoppingmall2.service.manager.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import indi.goddess.shoppingmall2.beans.TbItemCat;
import indi.goddess.shoppingmall2.dao.manager.ZTbItemCatDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.manager.ZItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZItemCatServiceImpl implements ZItemCatService {
    @Autowired
    private ZTbItemCatDao tbItemCatDao;
    @Override
    public List<TbItemCat> findAll() {
        return tbItemCatDao.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbItemCat> page= (Page<TbItemCat>) tbItemCatDao.findAll();
        return new PageResult(page.getTotal(),page.getResult());

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
