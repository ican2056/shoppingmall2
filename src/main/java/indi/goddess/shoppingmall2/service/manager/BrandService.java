package indi.goddess.shoppingmall2.service.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;

import java.util.List;

//品牌列表
public interface BrandService {
    //返回所有品牌列表
    public List<TbBrand> findAllBrand();
}
