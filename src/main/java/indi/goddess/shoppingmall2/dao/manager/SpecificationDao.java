package indi.goddess.shoppingmall2.dao.manager;


import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbSpecification;
import indi.goddess.shoppingmall2.beans.group.Specification;

import java.util.List;

public interface SpecificationDao {

    public List<TbSpecification> findAllSpecification();

    public void insert(TbSpecification record);
}
