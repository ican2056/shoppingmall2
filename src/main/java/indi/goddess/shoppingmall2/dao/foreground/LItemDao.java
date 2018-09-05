package indi.goddess.shoppingmall2.dao.foreground;

import indi.goddess.shoppingmall2.beans.TbItem;

import java.util.List;

public interface LItemDao {
	TbItem selectByItemId(Long itemId);

	List<TbItem> selectByLikeTitle(String title);
}
