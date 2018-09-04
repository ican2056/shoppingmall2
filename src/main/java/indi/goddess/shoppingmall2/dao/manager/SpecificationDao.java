package indi.goddess.shoppingmall2.dao.manager;


import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbSpecification;
import indi.goddess.shoppingmall2.beans.group.Specification;

import java.util.List;
import java.util.Map;

public interface SpecificationDao {

    public List<TbSpecification> findAllSpecification();

    public void insert(TbSpecification record);

    public void deleteByPrimaryKey(Long id);

    public TbSpecification selectByPrimaryKey(Long id);

    public List<TbSpecification> findByCondition(TbSpecification specification);


    public void updateByPrimaryKey(TbSpecification specification);

    // 获取下拉列表
    List<Map> selectOptionList();

}
