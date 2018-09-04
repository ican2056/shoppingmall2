package indi.goddess.shoppingmall2.dao.foreground.impl;

import indi.goddess.shoppingmall2.beans.TbItem;
import indi.goddess.shoppingmall2.dao.foreground.LItemDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LItemDaoImpl implements LItemDao {

	@Autowired
	SqlSessionTemplate sst;

	private String prefixSql="indi.goddess.shoppingmall2.beans.LItemMapper.";

	@Override
	public TbItem selectByItemId(Long itemId) {
		return sst.selectOne(prefixSql+"selectByPrimaryKey",itemId);
	}
}
