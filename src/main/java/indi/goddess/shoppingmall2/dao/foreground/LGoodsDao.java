package indi.goddess.shoppingmall2.dao.foreground;

import indi.goddess.shoppingmall2.beans.TbGoods;

public interface LGoodsDao{
	public TbGoods selectByPrimaryKey(Long goodsId);
}
