package indi.goddess.shoppingmall2.dao.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;

import java.util.List;
import java.util.Map;

public interface TbBrandDao {
    public List<TbBrand> findAllBrand();

    public void addBrand(TbBrand brand);

    /**
     * 修改品牌
     */
    public void updateByPrimaryKey(TbBrand brand);

    //根据id获取实体
    public TbBrand selectByPrimaryKey(Long id);

    public void deleteByPrimaryKey(Long id);

    public List<TbBrand> findByCondition(TbBrand tbBrand);

    // 获取下拉列表
    List<Map> selectOptionList();
}
