package indi.goddess.shoppingmall2.service.order.impl;

import indi.goddess.shoppingmall2.beans.TbOrder;
import indi.goddess.shoppingmall2.beans.TbPayLog;
import indi.goddess.shoppingmall2.dao.order.OrderDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.order.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Resource(name="orderDaoImpl")
	OrderDao orderDao;

	@Override
	public List<TbOrder> findAll() {
		return orderDao.findAll();
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
