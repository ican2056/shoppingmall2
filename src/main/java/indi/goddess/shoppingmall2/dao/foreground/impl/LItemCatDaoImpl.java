package indi.goddess.shoppingmall2.dao.foreground.impl;

import indi.goddess.shoppingmall2.beans.TbItemCat;
import indi.goddess.shoppingmall2.dao.foreground.LItemCatDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LItemCatDaoImpl implements LItemCatDao {

	@Autowired
	SqlSessionTemplate sst;

	private String prefixSql="indi.goddess.shoppingmall2.beans.LItemCatMapper.";

	@Override
	public TbItemCat selectById(long id) {
		return sst.selectOne(prefixSql+"selectByPrimaryKey",id);
	}
}
