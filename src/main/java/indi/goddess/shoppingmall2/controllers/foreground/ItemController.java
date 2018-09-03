package indi.goddess.shoppingmall2.controllers.foreground;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.beans.TbGoodsDesc;
import indi.goddess.shoppingmall2.dao.foreground.LGoodsDao;
import indi.goddess.shoppingmall2.dao.foreground.LGoodsDescDao;
import indi.goddess.shoppingmall2.service.foreground.LItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/item/")
public class ItemController {

	@Autowired
	LItemService lis;

	@RequestMapping("genItemHtml.action")
	public String  genItemHtml(ModelMap map){
		lis.genItemHtml(map,149187842867915L);
		return "item";
	}

}
