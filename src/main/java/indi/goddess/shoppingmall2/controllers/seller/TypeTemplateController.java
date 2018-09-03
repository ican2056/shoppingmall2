package indi.goddess.shoppingmall2.controllers.seller;


import indi.goddess.shoppingmall2.beans.TbTypeTemplate;
import indi.goddess.shoppingmall2.service.seller.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/typeTemplate/")
public class TypeTemplateController {

    @Autowired
    private TypeTemplateService typeTemplateService;

    @GetMapping("findOne")
    @ResponseBody
    public TbTypeTemplate findOne(Long id){
        TbTypeTemplate one = typeTemplateService.findOne(id);
        return one;
    }

    @GetMapping("findBySpecList")
    @ResponseBody
    //根据模板ID查询规格列表
    public List<Map> findSpecList(Long id){
        return typeTemplateService.findSpecList(id);
    }
}
