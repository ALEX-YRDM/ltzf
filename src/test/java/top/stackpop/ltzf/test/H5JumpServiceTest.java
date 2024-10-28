package top.stackpop.ltzf.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import top.stackpop.ltzf.factory.Configuration;
import top.stackpop.ltzf.factory.defaults.DefaultPayFactory;
import top.stackpop.ltzf.payments.h5Jump.model.QueryOrderByOutTradeNoRequest;
import top.stackpop.ltzf.payments.h5Jump.model.QueryOrderByOutTradeNoResponse;
import top.stackpop.ltzf.payments.h5Jump.model.PrepayRequest;
import top.stackpop.ltzf.payments.h5Jump.model.PrepayResponse;
import top.stackpop.ltzf.payments.h5Jump.H5JumpPayService;

import java.io.IOException;

/**
 * @author zbq
 * @date 2024/10/19 21:23
 */
@Slf4j
public class H5JumpServiceTest {
    private Configuration configuration;

    private H5JumpPayService h5JumpPayService;

    @Before
    public void init(){
        this.configuration=new Configuration("aaa","bbb");
        DefaultPayFactory factory = new DefaultPayFactory(configuration);
        this.h5JumpPayService = factory.getH5JumpPayService();

    }

    @Test
    public void test() throws IOException {
        PrepayRequest request = new PrepayRequest();
        request.setMchId("aaa");
        request.setOutTradeNo("NO202410192125");
        request.setTotalFee("0.01");
        request.setBody("huawei p70");
        request.setNotifyUrl("http://www.stackpop.top");
        PrepayResponse response = h5JumpPayService.prepay(request);
        //请求信息:{"body":"huawei p70","mch_id":"1695554857","notify_url":"http://www.stackpop.top","out_trade_no":"NO202410192125","timestamp":"1729344389","total_fee":"0.01"}
        //[main] INFO top.stackpop.ltzf.test.H5JumpServiceTest - 响应结果:{"code":0,"data":"https://api.ltzf.cn/template/html/jump_h5?order_no=WX202410192126292332414238","msg":"微信H5下单成功","request_id":"df17d675-ca1f-b6db-b65f-60f7b6bfe89e"}
        log.info("请求信息:{}", JSON.toJSONString(request));
        log.info("响应结果:{}",JSON.toJSONString(response));
    }

    @Test
    public void queryOrder() throws IOException {
        QueryOrderByOutTradeNoRequest request=new QueryOrderByOutTradeNoRequest();
        request.setMchId("1695554857");
        request.setOutTradeNo("NO202410192125");
        QueryOrderByOutTradeNoResponse response =
        h5JumpPayService.getPayOrder(request);
        //[main] INFO top.stackpop.ltzf.test.H5JumpServiceTest - 请求信息:{"mch_id":"1695554857","out_trade_no":"NO202410192125","timestamp":"1729344453"}
        //[main] INFO top.stackpop.ltzf.test.H5JumpServiceTest - 响应结果:{"code":0,"data":{"add_time":"2024-10-19 21:26:30","attach":"","body":"huawei p70","mch_id":"1695554857","order_no":"WX202410192126292332414238","out_trade_no":"NO202410192125","pay_status":0,"total_fee":"0.01","trade_type":"H5"},"msg":"查询成功","request_id":"66271058-2698-6a67-7d32-9cd6acb0ae81"}
        log.info("请求信息:{}", JSON.toJSONString(request));
        log.info("响应结果:{}",JSON.toJSONString(response));
    }
}
