package indi.goddess.shoppingmall2.dao.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbSeller;
import indi.goddess.shoppingmall2.beans.TbTypeTemplate;

import java.util.List;

public interface SellerDao {
    public List<TbSeller> findAllSeller();

    //根据id获取实体
    public TbSeller selectByPrimaryKey(String id);

    public int updateByPrimaryKey(TbSeller seller);

    public List<TbSeller> findByCondition(TbSeller seller);
}
