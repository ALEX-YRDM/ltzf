package top.stackpop.ltzf.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import top.stackpop.ltzf.factory.Configuration;
import top.stackpop.ltzf.factory.defaults.DefaultPayFactory;
import top.stackpop.ltzf.payments.nativepay.NativePayService;
import top.stackpop.ltzf.payments.nativepay.model.QueryOrderByOutTradeNoRequest;
import top.stackpop.ltzf.payments.nativepay.model.QueryOrderByOutTradeNoResponse;
import top.stackpop.ltzf.payments.nativepay.model.*;
import top.stackpop.ltzf.refund.RefundService;
import top.stackpop.ltzf.refund.model.GetRefundOrderRequest;
import top.stackpop.ltzf.refund.model.GetRefundOrderResponse;
import top.stackpop.ltzf.refund.model.RefundOrderRequest;
import top.stackpop.ltzf.refund.model.RefundOrderResponse;

import java.io.IOException;

/**
 * @author zbq
 * @date 2024/10/18 17:07
 */
@Slf4j
public class NativeServiceTest {

    private NativePayService nativePayService;

    private Configuration configuration;

    private RefundService refundService;

    @Before
    public void init(){
       configuration=new Configuration("aaa","bbb");
        DefaultPayFactory factory=new DefaultPayFactory(configuration);
        this.nativePayService=factory.getNativePayService();
        this.refundService = factory.getRefundService();
    }

    @Test
    public void prepay() throws IOException {

        PrepayRequest request=new PrepayRequest();
        request.setMchId("1695554857");
        request.setOutTradeNo("532287c6c6f34e1e895ed76417516c23");
        request.setBody("测试商品");
        request.setTotalFee("0.01");
        request.setNotifyUrl("http://www.stackpop.top/api/v1/sale/pay_notif");
        request.setTimeExpire("30m");
        PrepayResponse response = nativePayService.prepay(request);
        log.info(JSON.toJSONString(request));
        //{"code":0,"data":{"QRcode_url":"https://api.ltzf.cn/uploads/QRcode/wxpay/WX202410191733296257134226.png","code_url":"weixin://wxpay/bizpayurl?pr=Bqxp1H0z3"},"msg":"微信Native下单成功","request_id":"bf04ff50-e873-ec9a-1516-aa750417b0f6"}
        log.info(JSON.toJSONString(response));

    }

    @Test
    public void queryOrder() throws IOException {
        QueryOrderByOutTradeNoRequest request=new QueryOrderByOutTradeNoRequest();
        request.setMchId("1695554857");
        request.setOutTradeNo("202410191733");
        QueryOrderByOutTradeNoResponse response = nativePayService.getPayOrder(request);
        log.info(JSON.toJSONString(request));
        //未支付
        //{"code":0,"data":{"add_time":"2024-10-19 17:33:30","attach":"","body":"iphone16 promax 1tb","mch_id":"1695554857","order_no":"WX202410191733296257134226","out_trade_no":"202410191733","pay_status":0,"total_fee":"0.01","trade_type":"NATIVE"},"msg":"查询成功","request_id":"f36e9a9e-398c-42cd-bf97-518918083666"}

        //已支付
        //{"code":0,"data":{"add_time":"2024-10-19 17:33:30","attach":"","body":"iphone16 promax 1tb","mch_id":"1695554857","openid":"o5wq46PaOoY******x1MqC1FBiv0","order_no":"WX202410191733296257134226","out_trade_no":"202410191733","pay_no":"4200002403202410192376246421","pay_status":1,"success_time":"2024-10-19 17:34:51","total_fee":"0.01","trade_type":"NATIVE"},"msg":"查询成功","request_id":"246d91ee-cb28-a0db-7f4f-e672732ed053"}
        log.info(JSON.toJSONString(response));
    }

    @Test
    public void refundOrder() throws IOException {
        RefundOrderRequest request=new RefundOrderRequest();
        request.setMchId("1695554857");
        request.setOutTradeNo("2024101917xx");
        request.setOutRefundNo("TK2024101917xx");
        request.setRefundFee("0.01");
        RefundOrderResponse response = refundService.refundOrder(request);
        log.info(JSON.toJSONString(request));
        //{"code":0,"data":{"mch_id":"1695554857","order_no":"T02024101997981029","out_refund_no":"TK2024101917xx","out_trade_no":"2024101917xx","pay_refund_no":"50302100982024101923465723443"},"msg":"发起退款成功","request_id":"b5671dde-ccff-cc55-cade-34bfb75de60b"}
        log.info(JSON.toJSONString(response));

    }

    @Test
    public void getRefundOrder() throws IOException {
        GetRefundOrderRequest request=new GetRefundOrderRequest();
        request.setMchId("1695554857");
        request.setOutRefundNo("TK2024101917xx");
        GetRefundOrderResponse response = refundService.getRefundOrder(request);
        log.info(JSON.toJSONString(request));
        //{"code":1,"msg":"退款60秒内不允许调用此接口","request_id":"1a6daeef-ba95-21ab-8c9c-1f2fab55c05d"}

        //{"code":0,"data":{"mch_id":"1695554857","order_no":"T02024101997981029","out_refund_no":"TK202410191xxx","out_trade_no":"202410191733","pay_no":"4200002403202410192376246421","pay_refund_no":"50302100982024101923465723443","refund_fee":"0.01","refund_status":1,"success_time":"2024-10-19 17:35:58","user_received_account":"支付用户零钱"},"msg":"查询成功","request_id":"68193521-a4d7-7624-55d5-b1fe54017f06"}
        log.info(JSON.toJSONString(response));
    }
}
