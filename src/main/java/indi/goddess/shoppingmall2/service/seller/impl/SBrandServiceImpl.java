package indi.goddess.shoppingmall2.service.seller.impl;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.seller.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SBrandServiceImpl implements BrandService {
    @Override
    public List<TbBrand> findAll() {
        return null;
    }

    @Override
    public PageResult findByPage(TbBrand brand, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void save(TbBrand brand) {

    }

    @Override
    public TbBrand findById(Long id) {
        return null;
    }

    @Override
    public void update(TbBrand brand) {

    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public List<Map> selectOptionList() {
        return null;
    }
}
