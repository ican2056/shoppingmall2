package indi.goddess.shoppingmall2.dao.foreground.impl;

import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.dao.foreground.LGoodsDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LGoodsDaoImpl implements LGoodsDao {

	@Autowired
	SqlSessionTemplate sst;

	private String base="indi.goddess.shoppingmall2.beans.LTbGoodsMapper.";

	@Override
	public TbGoods selectByPrimaryKey(Long goodsId) {
		return sst.selectOne(base+"selectByPrimaryKey",goodsId);
	}
}
