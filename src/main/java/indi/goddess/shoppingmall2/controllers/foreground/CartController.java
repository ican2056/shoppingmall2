package indi.goddess.shoppingmall2.controllers.foreground;

import com.alibaba.fastjson.JSON;
import indi.goddess.shoppingmall2.beans.group.Cart;
import indi.goddess.shoppingmall2.entity.Result;
import indi.goddess.shoppingmall2.service.foreground.CartService;
import indi.goddess.shoppingmall2.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/cart/")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping("/findCartList")
	@ResponseBody
	public List<Cart> findCartList(HttpServletRequest request, HttpServletResponse response) {
		String cartListString = CookieUtil.getCookieValue(request, "cartList", "UTF-8");
		if (cartListString == null || cartListString.equals("")) {
			cartListString = "[]";
		}
		List<Cart> cartList_cookie = JSON.parseArray(cartListString, Cart.class);
		return cartList_cookie;
	}

	@RequestMapping("/addGoodsToCartList")
	@ResponseBody
	public Result addGoodsToCartList(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Cart> cartList = findCartList(request, response);//获取购物车列表
			cartList = cartService.addGoodsToCartList(cartList, itemId, num);
			CookieUtil.setCookie(request, response, "cartList", JSON.toJSONString(cartList), 3600 * 24, "UTF-8");
			return new Result(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}

	@RequestMapping("/toCartHtml")
	public String toCartHTML(){

		return "cart";
	}
}

