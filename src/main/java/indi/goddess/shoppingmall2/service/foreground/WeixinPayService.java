package indi.goddess.shoppingmall2.service.foreground;

import java.util.Map;

public interface WeixinPayService {

    /**
     * 生成本地支付的数据信息
     *
     * @param out_trade_no 外部订单号
     * @param total_fee    金额，单位为：分
     * @return java.util.Map
     */
    Map createNative(String out_trade_no, String total_fee);
}