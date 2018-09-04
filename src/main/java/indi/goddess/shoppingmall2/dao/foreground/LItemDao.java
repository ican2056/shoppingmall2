package indi.goddess.shoppingmall2.dao.foreground;

import indi.goddess.shoppingmall2.beans.TbItem;

public interface LItemDao {
	TbItem selectByItemId(Long itemId);
}
