package indi.goddess.shoppingmall2.controllers.manager;


import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbItemCat;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.entity.Result;
import indi.goddess.shoppingmall2.service.manager.ZItemCatService;
import indi.goddess.shoppingmall2.service.seller.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/manager/itemcat/")
public class ZItemCatController {
    @Autowired
    private ZItemCatService itemCatService;

    @RequestMapping("/add")
    public Result add(@RequestBody TbItemCat itemCat){
        try {
            itemCatService.add(itemCat);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    @RequestMapping("findAll")
    @ResponseBody
    public List<TbItemCat> findAll(){
        List<TbItemCat> all = itemCatService.findAll();
        return all;
    }

    /**
     * 修改
     * @param
     * @return
     */
    @RequestMapping("update")
    public Result update(@RequestBody TbItemCat itemCat){
        try {
            itemCatService.update(itemCat);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("findPage")
    public PageResult findPage(int page, int rows){
        return itemCatService.findPage(page, rows);
    }

    @RequestMapping("findOne")
    @ResponseBody
    public TbItemCat findOne(Long id){
        return itemCatService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            itemCatService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @GetMapping("findByParentId")
    @ResponseBody
    public List<TbItemCat> findByParentId(Long parentId) {
        List<TbItemCat> list = itemCatService.findByParentId(parentId);
       // System.out.println(list);
        return list;
    }

}
