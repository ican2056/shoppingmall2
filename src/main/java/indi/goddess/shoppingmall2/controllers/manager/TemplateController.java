package indi.goddess.shoppingmall2.controllers.manager;

import com.google.gson.Gson;
import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbTypeTemplate;
import indi.goddess.shoppingmall2.beans.TbTypeTemplate2;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.entity.Result;
import indi.goddess.shoppingmall2.service.manager.TemplateService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
@RestController
@RequestMapping("/manager/typeTemplate")
public class TemplateController {
    @Resource(name = "templateServiceImpl")
    private TemplateService templateService;
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return templateService.findPage(page, rows);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbTypeTemplate2 template){
        try {
            //System.out.println("template>>>>"+template.getBrandIds());
            Gson g=new Gson();
            String BrandIds = g.toJson(template.getBrandIds());
            String CustomAttributeItems = g.toJson(template.getCustomAttributeItems());
            String SpecIds = g.toJson(template.getSpecIds());
            TbTypeTemplate temp=new TbTypeTemplate();
            temp.setBrandIds(BrandIds);
            temp.setCustomAttributeItems(CustomAttributeItems);
            temp.setSpecIds(SpecIds);
            temp.setId(template.getId());
            temp.setName(template.getName());
            //System.out.println(s);
            templateService.add(temp);

            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbTypeTemplate2 template){
        try {
            Gson g=new Gson();
            String BrandIds = g.toJson(template.getBrandIds());
            String CustomAttributeItems = g.toJson(template.getCustomAttributeItems());
            String SpecIds = g.toJson(template.getSpecIds());
            TbTypeTemplate temp=new TbTypeTemplate();
            temp.setBrandIds(BrandIds);
            temp.setCustomAttributeItems(CustomAttributeItems);
            temp.setSpecIds(SpecIds);
            temp.setId(template.getId());
            temp.setName(template.getName());
            templateService.update(temp);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }
    //获取实体
    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(Long id){
        return templateService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            templateService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbTypeTemplate template, int page, int rows  ){
        return  templateService.findPageByCondition(template,page,rows);
    }
}
