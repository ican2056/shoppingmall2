package indi.goddess.shoppingmall2.controllers.seller;

import com.alibaba.fastjson.JSON;
import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.beans.group.Goods;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.entity.Result;
import indi.goddess.shoppingmall2.service.seller.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletConfigAware;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/goods/")
public class GoodsController implements ServletConfigAware {

    @Resource(name="goodsServiceImpl")
    private GoodsService goodsService;

    ServletConfig servletConfig;

    @GetMapping("findAll")
    @ResponseBody
    public List<TbGoods> findAll(){
        List<TbGoods> all = goodsService.findAll();
        return all;
    }

    @GetMapping("findOne")
    @ResponseBody
    public Goods findOne(Long id){
         Goods one = goodsService.findOne(id);
        return one;
    }

    @PostMapping("findPage")
    @ResponseBody
    public PageResult findPage(int page, int rows,int auditStatus){
        PageResult pageResult = goodsService.findPage(page, rows,auditStatus);
        return pageResult;
    }


    @PostMapping("add.do")
    @ResponseBody
    public Result add(@RequestBody()Map<String,Object> goods) {
        Goods g=JSON.parseObject(JSON.toJSONString(goods),Goods.class);
        try {
            goodsService.add(g);
            return new Result(true, g.getGoods().getId()+"");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    @PostMapping("update.do")
    @ResponseBody
    public Result update(@RequestBody()Map<String,Object> goods) {
        Goods g=JSON.parseObject(JSON.toJSONString(goods),Goods.class);
        //校验是否是当前商家的id
        Goods goods2 = goodsService.findOne(g.getGoods().getId());
        //获取当前登录的商家ID
       // String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        String sellerId ="baidu";
        //如果传递过来的商家ID并不是当前登录的用户的ID,则属于非法操作
//        if(!goods2.getGoods().getSellerId().equals(sellerId) ||  !g.getGoods().getSellerId().equals(sellerId) ){
//            return new Result(false, "操作非法");
//        }
        try {
            goodsService.update(g);
            return new Result(true, g.getGoods().getId()+"");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }

    }


    @GetMapping("delete.do")
    @ResponseBody
    public Result delete(Long[] ids){
        goodsService.delete(ids);
        Result result=new Result(true,"删除成功");
        return result;
    }


    /**
     * 更新状态
     * @param ids
     * @param status
     */
    @RequestMapping("/updateStatu.do")
    @ResponseBody
    public Result updateStatus(Long[] ids, String status){
        try {
            goodsService.updateStatus(ids, status);
            return new Result(true, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "失败");
        }
    }


    @Override
    public void setServletConfig(ServletConfig servletConfig) {
        this.servletConfig=servletConfig;
    }
}
