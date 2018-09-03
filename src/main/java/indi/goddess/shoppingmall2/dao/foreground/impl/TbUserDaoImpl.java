package indi.goddess.shoppingmall2.dao.foreground.impl;

import indi.goddess.shoppingmall2.beans.TbUser;
import indi.goddess.shoppingmall2.dao.foreground.TbUserDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbUserDaoImpl implements TbUserDao {
	private final String MAPPERPATH = "com.goddess.beans.";
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public TbUser findOne(TbUser tbUser, String sqlId) {
		System.out.println(tbUser);
		List<TbUser> list = sqlSession.selectList(MAPPERPATH + tbUser.getClass().getSimpleName() + "Mapper." + sqlId,tbUser);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}


	@Override
	public int  deleteByPrimaryKey(Long id,String sqlId) {
		return  sqlSession.delete("com.goddess.beans.TbUserMapper" +sqlId,id);

	}

	@Override
	public int insert(TbUser record, String sqlId) {
		int result=  sqlSession.insert(MAPPERPATH + record.getClass().getSimpleName() + "Mapper." + sqlId, record);
		return result;
	}

	@Override
	public int insertSelective(TbUser record) {
		return 0;
	}


	@Override
	public TbUser selectByPrimaryKey(Long id,String sqlId ) {
		TbUser u  = sqlSession.selectOne("com.goddess.beans.TbUserMapper" +sqlId,id);
		return u;
	}


	@Override
	public int updateByPrimaryKeySelective(TbUser record, String sqlId) {
		int result= sqlSession.update(MAPPERPATH+record.getClass().getSimpleName()+"Mapper." +sqlId,record);
		return result;
	}

	@Override
	public int updateByPrimaryKey(TbUser record) {
		return 0;
	}
}
