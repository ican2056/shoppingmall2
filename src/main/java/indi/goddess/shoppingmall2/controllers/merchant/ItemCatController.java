package indi.goddess.shoppingmall2.controllers.merchant;


import indi.goddess.shoppingmall2.beans.TbItemCat;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.merchant.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/merchant/itemcat/")
public class ItemCatController {
    @Resource(name="itemCatServiceImpl")
    private ItemCatService itemCatService;

    @ResponseBody
    @PostMapping("add")
    public void add(TbItemCat itemCat){
        itemCatService.add(itemCat);
    }

    @PostMapping("findAll")
    @ResponseBody
    public String findAll(){
        List<TbItemCat> all = itemCatService.findAll();
        return all.toString();
    }

    @PostMapping("update")
    public void update(TbItemCat itemCat){
        itemCatService.update(itemCat);
    }

    @PostMapping("findPage")
    @ResponseBody
    public PageResult findPage(int pageNum, int pageSize){
       return itemCatService.findPage(pageNum,pageSize);
    }

    @PostMapping("findOne")
    public TbItemCat findOne(Long id){
        return itemCatService.findOne(id);
    }

    @PostMapping("delete")
    public void delete(Long[] ids){
        itemCatService.delete(ids);
    }
}
