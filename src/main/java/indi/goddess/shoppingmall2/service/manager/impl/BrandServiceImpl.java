package indi.goddess.shoppingmall2.service.manager.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.dao.manager.TbBrandDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.manager.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandDao BrandDao;



    @Override
    public List<TbBrand> findAllBrand() {
        return BrandDao.findAllBrand();
    }
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page= (Page<TbBrand>) BrandDao.findAllBrand();
        return new PageResult(page.getTotal(),page.getResult());

    }

    @Override
    public void add(TbBrand brand) {
        BrandDao.addBrand(brand);
    }

    @Override
    public void update(TbBrand brand) {
        BrandDao.updateByPrimaryKey(brand);
    }

    @Override
    public TbBrand findOne(Long id) {
        return BrandDao.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            BrandDao.deleteByPrimaryKey(id);
        }
    }
    @Override
    public PageResult findPageByCondition(TbBrand brand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page= (Page<TbBrand>) BrandDao.findByCondition(brand);
        return new PageResult(page.getTotal(), page.getResult());

    }

    @Override
    public List<Map> selectOptionList() {
        return BrandDao.selectOptionList();
    }
}
