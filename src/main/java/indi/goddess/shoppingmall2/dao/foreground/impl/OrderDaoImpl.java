package indi.goddess.shoppingmall2.dao.foreground.impl;

import indi.goddess.shoppingmall2.beans.TbOrder;
import indi.goddess.shoppingmall2.beans.TbPayLog;
import indi.goddess.shoppingmall2.dao.foreground.OrderDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	SqlSessionTemplate sst;

	private String prefixSql="indi.goddess.shoppingmall2.mapper.OrderMapper.";

	@Override
	public List<TbOrder> findAll() {
		return sst.selectList(prefixSql+"findAll",TbOrder.class);
	}

	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		return null;
	}

	@Override
	public void add(TbOrder order) {

	}

	@Override
	public void update(TbOrder order) {

	}

	@Override
	public TbOrder findOne(Long id) {
		return null;
	}

	@Override
	public void delete(Long[] ids) {

	}

	@Override
	public PageResult findPage(TbOrder order, int pageNum, int pageSize) {
		return null;
	}

	@Override
	public TbPayLog searchPayLogFromRedis(String userId) {
		return null;
	}

	@Override
	public void updateOrderStatus(String out_trade_no, String transaction_id) {

	}
}
