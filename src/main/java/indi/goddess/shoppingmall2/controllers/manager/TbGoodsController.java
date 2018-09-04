package indi.goddess.shoppingmall2.controllers.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.entity.Result;
import indi.goddess.shoppingmall2.service.manager.TbGoodsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manager/goods")
public class TbGoodsController {

    @Resource(name="tbGoodsServiceImpl")
    private TbGoodsService goodsService;

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return goodsService.findPage(page, rows);
    }

    @RequestMapping("/updateStatus")
    public Result updateStatus(Long[] ids, String status){
        try {
            System.out.println(ids+">>>>>>>>>"+status);
            goodsService.updateStatus(ids, status);
            return new Result(true, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            goodsService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbGoods good, int page, int rows  ){
        return  goodsService.findPageByCondition(good,page,rows);
    }
}
