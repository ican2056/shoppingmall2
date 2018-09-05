package indi.goddess.shoppingmall2.controllers.foreground;

import indi.goddess.shoppingmall2.beans.TbItem;
import indi.goddess.shoppingmall2.service.foreground.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/search/")
public class SearchController {

	@Autowired
	SearchService ss;

	@RequestMapping("toSearchHtml")
	public String toSearchHtml(String searchKey,ModelMap map){
		//System.out.println("searchKey:>>>>"+searchKey);
		//调用搜索服务
		//List<TbItem> tbItems = ss.searchByLikeTitle(searchKey);
		//System.out.println(tbItems.get(0).getTitle());
		map.put("searchKey",searchKey==null?"":searchKey);
		return "search";
	}
}
