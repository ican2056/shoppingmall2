package indi.goddess.shoppingmall2.dao.user;

import indi.goddess.shoppingmall2.beans.TbUser;

public interface TbUserDao {
	TbUser findOne(TbUser tbUser, String sqlId);

	int deleteByPrimaryKey(Long id, String sqlId);

	int insert(TbUser record, String sqlId);

	int insertSelective(TbUser record);

	TbUser selectByPrimaryKey(Long id, String sqlId);

	int updateByPrimaryKeySelective(TbUser record, String sqlId);

	int updateByPrimaryKey(TbUser record);
}