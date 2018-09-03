package indi.goddess.shoppingmall2.dao.foreground;

import indi.goddess.shoppingmall2.beans.TbGoodsDesc;

public interface LGoodsDescDao {
	public TbGoodsDesc selectByPrimaryKey(Long goodsId);
}
