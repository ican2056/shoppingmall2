package indi.goddess.shoppingmall2.controllers.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbSeller;
import indi.goddess.shoppingmall2.beans.group.Specification;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.entity.Result;
import indi.goddess.shoppingmall2.service.manager.TbSellerService;
import indi.goddess.shoppingmall2.service.manager.TemplateService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manager/seller")
public class TbSellerController {
    @Resource(name = "tbSellerServiceImpl")
    private TbSellerService sellerService;

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return sellerService.findPage(page, rows);
    }

    @RequestMapping("/findOne")
    public TbSeller findOne(String id){
        return sellerService.findOne(id);
    }

    /**
     * 更改状态
     * @param sellerId 商家ID
     * @param status 状态
     */
    @RequestMapping("/updateStatus")
    // 0：未审核   1：已审核   2：审核未通过   3：关闭
    public Result updateStatus(String sellerId, String status){
        try {
            sellerService.updateStatus(sellerId, status);
            return new Result(true, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "失败");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbSeller seller, int page, int rows  ){
        return  sellerService.findPageByCondition(seller,page,rows);
    }
}
