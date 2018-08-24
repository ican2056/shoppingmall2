package indi.goddess.shoppingmall2.dao.user;

import indi.goddess.shoppingmall2.beans.TbUser;

public interface TbUserDao {
	TbUser findOne(TbUser tbUser, String sqlId);

	int deleteByPrimaryKey(Long id);

	int insert(TbUser record, String sqlId);

	int insertSelective(TbUser record);

	TbUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(TbUser record);

	int updateByPrimaryKey(TbUser record);
}