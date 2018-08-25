package indi.goddess.shoppingmall2.service.manager.impl;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.dao.manager.TbBrandDao;
import indi.goddess.shoppingmall2.service.manager.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandDao BrandDao;

    @Override
    public List<TbBrand> findAllBrand() {
        return BrandDao.findAllBrand();
    }
}
