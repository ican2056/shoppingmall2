package indi.goddess.shoppingmall2.dao.user.impl;

import indi.goddess.shoppingmall2.beans.TbUser;
import indi.goddess.shoppingmall2.dao.user.TbUserDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbUserDaoImpl implements TbUserDao {
	private final String MAPPERPATH = "com.goddess.bean.";
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public TbUser findOne(TbUser tbUser, String sqlId) {
		List<TbUser> list = sqlSession.selectList(MAPPERPATH + tbUser.getClass().getSimpleName() + "Mapper." + sqlId);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}


	@Override
	public int deleteByPrimaryKey(Long id) {
		return 0;
	}

	@Override
	public int insert(TbUser record, String sqlId) {
		return sqlSession.insert(MAPPERPATH + record.getClass().getSimpleName() + "Mapper." + sqlId, record);
	}

	@Override
	public int insertSelective(TbUser record) {
		return 0;
	}


	@Override
	public TbUser selectByPrimaryKey(Long id) {
		return null;
	}


	@Override
	public int updateByPrimaryKeySelective(TbUser record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TbUser record) {
		return 0;
	}
}
