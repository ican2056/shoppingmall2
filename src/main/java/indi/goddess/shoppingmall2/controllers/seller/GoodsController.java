package indi.goddess.shoppingmall2.controllers.seller;

import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.beans.TbItemCat;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.seller.GoodsService;
import indi.goddess.shoppingmall2.service.seller.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/seller/goods/")
public class GoodsController {

    @Resource(name="goodsServiceImpl")
    private GoodsService goodsService;

    @GetMapping("findAll")
    @ResponseBody
    public List<TbGoods> findAll(){
        List<TbGoods> all = goodsService.findAll();
        return all;
    }

    @GetMapping("findOne")
    public String findOne(Long id){
        if(id==null){
            //查询所有类目
            List<TbGoods> all = findAll();
            return all.toString();
        }
        return null;
    }

    @PostMapping("findPage")
    @ResponseBody
    public PageResult findPage(int page, int rows){
        PageResult pageResult = goodsService.findPage(page, rows);
        return pageResult;
    }
}
