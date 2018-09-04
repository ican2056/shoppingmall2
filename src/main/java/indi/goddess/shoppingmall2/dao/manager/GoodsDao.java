package indi.goddess.shoppingmall2.dao.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbGoods;

import java.util.List;

public interface GoodsDao {
    public List<TbGoods> findAllGood();

    public TbGoods selectByPrimaryKey(Long id);

    public int updateByPrimaryKey(TbGoods goods);

    public List<TbGoods> findByCondition(TbGoods good);
}
