package indi.goddess.shoppingmall2.service.foreground;

import indi.goddess.shoppingmall2.beans.TbItem;

import java.util.List;

public interface SearchService {
	List<TbItem> searchByLikeTitle(String title);
}
