package indi.goddess.shoppingmall2.service.foreground;

import org.springframework.ui.ModelMap;

public interface LItemService {
	void genItemHtml(ModelMap map,long goodsId);
}
