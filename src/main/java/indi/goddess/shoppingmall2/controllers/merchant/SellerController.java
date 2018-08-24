package indi.goddess.shoppingmall2.controllers.merchant;

import indi.goddess.shoppingmall2.beans.TbSeller;
import indi.goddess.shoppingmall2.service.merchant.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/merchant/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("add")
    public void add(TbSeller tbSeller){
        int result = sellerService.add(tbSeller);

    }

    @PostMapping("login")
    public String login(TbSeller tbSeller){
        TbSeller login = sellerService.login(tbSeller);
        if(login!=null){
            return "/admin/index";
        }else{
            return "shoplogin";
        }
    }
}
