package indi.goddess.shoppingmall2.controllers.manager;


import indi.goddess.shoppingmall2.entity.PageResult;

import indi.goddess.shoppingmall2.service.manager.SpecificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manager/specification")
public class SpecificationController {
    @Resource(name="specificationServiceImpl")
    private SpecificationService specificationService;
    //分页
    @RequestMapping("/findByPage")
    public PageResult findPage(int page, int rows){
        return specificationService.findPage(page, rows);
    }
}
