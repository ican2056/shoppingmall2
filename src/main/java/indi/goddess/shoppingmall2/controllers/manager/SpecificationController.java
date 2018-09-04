package indi.goddess.shoppingmall2.controllers.manager;


import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbSpecification;
import indi.goddess.shoppingmall2.beans.group.Specification;
import indi.goddess.shoppingmall2.entity.PageResult;

import indi.goddess.shoppingmall2.entity.Result;
import indi.goddess.shoppingmall2.service.manager.SpecificationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/add")
    public Result add(@RequestBody Specification specification){
        try {
            specificationService.add(specification);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            specificationService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("/findOne")
    public Specification findOne(Long id){
        return specificationService.findOne(id);
    }

    /**
     * 修改
     * @param specification
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Specification specification){
        try {
            specificationService.update(specification);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return specificationService.selectOptionList();
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbSpecification specification, int page, int rows  ){
        return  specificationService.findPageByCondition(specification,page,rows);
    }
}
