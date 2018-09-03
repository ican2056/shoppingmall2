package indi.goddess.shoppingmall2.dao.foreground.impl;

import indi.goddess.shoppingmall2.beans.TbGoodsDesc;
import indi.goddess.shoppingmall2.dao.foreground.LGoodsDescDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LGoodsDescDaoImpl implements LGoodsDescDao {

	private String base="indi.goddess.shoppingmall2.beans.LGoodsDescMapper.";

	@Autowired
	SqlSessionTemplate sst;

	@Override
	public TbGoodsDesc selectByPrimaryKey(Long goodsId) {
		return sst.selectOne(base+"selectByPrimaryKey",goodsId);
	}
}
