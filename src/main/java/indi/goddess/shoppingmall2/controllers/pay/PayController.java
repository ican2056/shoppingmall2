package indi.goddess.shoppingmall2.controllers.pay;

import indi.goddess.shoppingmall2.service.pay.WeixinPayService;
import indi.goddess.shoppingmall2.utils.pay.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
//@Api(value = "/test",tags = "TestSwaggerController模块")
@RestController
@RequestMapping("/pay/")
public class PayController {

    @Autowired
    private WeixinPayService weixinPayService;

    /**
     * 生成二维码数据
     *
     * @return java.util.Map
     */
    //              value:方法描述      notes:方法提示内容
    //@ApiOperation(value = "用户支付",notes = "方法的提示：用户支付")
    // path, query, body, header, form，表明数据来自哪里
    @RequestMapping("createNative")
    public Map createNative(){
        IdWorker idWorker = new IdWorker();
        //System.out.println(String.valueOf(idWorker.nextId())+">>>>>>>>>");
        return weixinPayService.createNative(String.valueOf(idWorker.nextId()), "1");
    }
}
