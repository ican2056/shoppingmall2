package indi.goddess.shoppingmall2.dao.manager;

import indi.goddess.shoppingmall2.beans.TbSpecificationOption;

import java.util.List;

public interface TbSpecificationOptionDao {


    public List<TbSpecificationOption> selectById(Long id);

    public void insert(TbSpecificationOption specificationOption);

    public void delete(TbSpecificationOption option);

}
