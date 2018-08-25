package indi.goddess.shoppingmall2.controllers.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.service.manager.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/manager/brand")
public class BrandController {
    @Resource(name = "brandServiceImpl")
    private BrandService brandService;
    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAllBrand")
    public List<TbBrand> findAll(){
        return brandService.findAllBrand();
    }
}