package indi.goddess.shoppingmall2.service.foreground.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.beans.TbGoodsDesc;
import indi.goddess.shoppingmall2.beans.TbItemCat;
import indi.goddess.shoppingmall2.dao.foreground.LGoodsDao;
import indi.goddess.shoppingmall2.dao.foreground.LGoodsDescDao;
import indi.goddess.shoppingmall2.dao.foreground.LItemCatDao;
import indi.goddess.shoppingmall2.service.foreground.LItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LItemServiceImpl implements LItemService {

	@Autowired
	LGoodsDao lgs;
	@Autowired
	LGoodsDescDao lgds;
	@Autowired
	LItemCatDao licd;

	@Override
	public void genItemHtml(ModelMap map,long goodsId) {
		Gson g=new Gson();
		TbGoods tbGoods = lgs.selectByPrimaryKey(goodsId);
		TbGoodsDesc tbGoodsDesc = lgds.selectByPrimaryKey(goodsId);
		TbItemCat itemCat1 = licd.selectById((tbGoods.getCategory1Id()));
		TbItemCat itemCat2 = licd.selectById((tbGoods.getCategory2Id()));
		TbItemCat itemCat3 = licd.selectById((tbGoods.getCategory3Id()));
		System.out.println(itemCat3.getName());

		String jsonStr_ItemImages=tbGoodsDesc.getItemImages();
		String jsonStr_CustomAttributeItems=tbGoodsDesc.getCustomAttributeItems();
		String jsonStr_SpecificationItems=tbGoodsDesc.getSpecificationItems();

		//new TypeToken<List<Map<String, Object>>>(){}.getType()是为了转成List<Map<String, String>>
		List<Map<String, String>> list= g.fromJson(jsonStr_ItemImages, new TypeToken<List<Map<String, String>>>(){}.getType());
		List<Map<String, String>> list_CustomAttributeItems= g.fromJson(jsonStr_CustomAttributeItems, new TypeToken<List<Map<String, String>>>(){}.getType());
		List list_SpecificationItems= g.fromJson(jsonStr_SpecificationItems,List.class);

		map.put("goods",tbGoods);
		map.put("goodsDesc",tbGoodsDesc);
		map.put("list",list);
		map.put("list_SpecificationItems",list_SpecificationItems);
		map.put("list_CustomAttributeItems",list_CustomAttributeItems);
		map.put("itemCat1",itemCat1);
		map.put("itemCat2",itemCat2);
		map.put("itemCat3",itemCat3);
	}

}
