package indi.goddess.shoppingmall2.service.foreground.impl;

import indi.goddess.shoppingmall2.beans.TbItem;
import indi.goddess.shoppingmall2.beans.TbOrderItem;
import indi.goddess.shoppingmall2.beans.group.Cart;
import indi.goddess.shoppingmall2.dao.foreground.LItemDao;
import indi.goddess.shoppingmall2.service.foreground.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	LItemDao lid;

	@Override
	public List<Cart> addGoodsToCartList(List<Cart> cartList, Long itemId, Integer num) {
		//查询商品明细对象
		TbItem item = lid.selectByItemId(itemId);
		if(item==null){
			throw new RuntimeException("商品不存在");
		}
		//2.根据SKU对象得到商家ID
		String sellerId = item.getSellerId();//商家ID

		Cart cart = cartList.get(0);
		if(cart==null){
			//4.1 创建一个新的购物车对象
			cart=new Cart();
			cart.setSellerId(sellerId);//商家ID
			cart.setSellerName(item.getSeller());//商家名称
			List<TbOrderItem> orderItemList=new ArrayList();//创建购物车明细列表
			TbOrderItem orderItem = createOrderItem(item,num);
			orderItemList.add(orderItem);
			cart.setOrderItemList(orderItemList);
			//4.2将新的购物车对象添加到购物车列表中
			cartList.add(cart);
		}else{
			// 判断该商品是否在该购物车的明细列表中存在
			TbOrderItem orderItem = searchOrderItemByItemId(cart.getOrderItemList(),itemId);
			if(orderItem==null){
				//5.1  如果不存在,创建新的购物车明细对象，并添加到该购物车的明细列表中
				orderItem=createOrderItem(item,num);
				cart.getOrderItemList().add(orderItem);
			}else{
				//5.2 如果存在，在原有的数量上添加数量 ,并且更新金额
				orderItem.setNum(orderItem.getNum()+num);//更改数量
				//金额
				orderItem.setTotalFee(new BigDecimal(orderItem.getPrice().doubleValue()*orderItem.getNum()));
				//当明细的数量小于等于0，移除此明细
				if(orderItem.getNum()<=0){
					cart.getOrderItemList().remove(orderItem);
				}
				//当购物车的明细数量为0，在购物车列表中移除此购物车
				if(cart.getOrderItemList().size()==0){
					cartList.remove(cart);
				}
			}
		}
		return cartList;
	}

	/**
	 * 根据skuID在购物车明细列表中查询购物车明细对象
	 * @param orderItemList
	 * @param itemId
	 * @return
	 */
	public TbOrderItem searchOrderItemByItemId(List<TbOrderItem> orderItemList, Long itemId){
		for(TbOrderItem orderItem:orderItemList){
			if(orderItem.getItemId().longValue()==itemId.longValue()){
				return orderItem;
			}
		}
		return null;
	}

	/**
	 * 创建购物车明细对象
	 * @param item
	 * @param num
	 * @return
	 */
	private TbOrderItem createOrderItem(TbItem item,Integer num){
		//创建新的购物车明细对象
		TbOrderItem orderItem=new TbOrderItem();
		orderItem.setGoodsId(item.getGoodsId());
		orderItem.setItemId(item.getId());
		orderItem.setNum(num);
		orderItem.setPicPath(item.getImage());
		orderItem.setPrice(item.getPrice());
		orderItem.setSellerId(item.getSellerId());
		orderItem.setTitle(item.getTitle());
		orderItem.setTotalFee(  new BigDecimal(item.getPrice().doubleValue()*num) );
		return orderItem;
	}

	@Override
	public List<Cart> findCartListFromRedis(String username) {
		return null;
	}

	@Override
	public void saveCartListToRedis(String username, List<Cart> cartList) {

	}

	@Override
	public List<Cart> mergeCartList(List<Cart> cartList1, List<Cart> cartList2) {
		return null;
	}
}
