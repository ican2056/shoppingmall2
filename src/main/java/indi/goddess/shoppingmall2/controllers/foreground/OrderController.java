package indi.goddess.shoppingmall2.controllers.foreground;

import indi.goddess.shoppingmall2.beans.TbOrder;
import indi.goddess.shoppingmall2.service.foreground.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/order/")
public class OrderController {

	@Resource(name = "orderServiceImpl")
	OrderService orderService;

	@RequestMapping("findAll")
	//@ResponseBody
	public String findAll(){
		List<TbOrder> all = orderService.findAll();
		System.out.println(all.get(3));
		return "redirect:/manager/login.html";
	}
}
