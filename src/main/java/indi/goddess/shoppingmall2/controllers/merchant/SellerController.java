package indi.goddess.shoppingmall2.controllers.merchant;

import indi.goddess.shoppingmall2.beans.TbSeller;
import indi.goddess.shoppingmall2.service.merchant.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/foreground/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("/add")
    @ResponseBody
    public Map add(@RequestBody TbSeller seller){
        int result = sellerService.add(seller);
        Map<String,Object> map=new HashMap<String, Object>();
        if(result>0){
            System.out.println("11111");
            map.put("message","恭喜，注册成功");
            map.put("flag",true);
        }else{
            System.out.println("2222222");
            map.put("message","注册失败，请重新注册");
            map.put("flag",false);
        }
            return map;
    }

    /*
    @RequestMapping("/login")
    public String login(String nick_name, String password){
        ModelAndView mav =new ModelAndView();
        TbSeller seller = new TbSeller();
        seller.setNickName(nick_name);
        seller.setPassword(password);
        seller = sellerService.login(seller);

        System.out.println(">>>>>>>");

        if(seller!=null){
            return "/merchant/form";
        }else{
            return "";
        }
    }

    */
}
