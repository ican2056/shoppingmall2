package indi.goddess.shoppingmall2.service.foreground.impl;

import indi.goddess.shoppingmall2.beans.TbItem;
import indi.goddess.shoppingmall2.dao.foreground.LItemDao;
import indi.goddess.shoppingmall2.service.foreground.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class SearchServiceImpl implements SearchService {

	@Autowired
	LItemDao lid;

	@Override
	public List<TbItem> searchByLikeTitle(String title) {
		return lid.selectByLikeTitle(title);
	}
}
