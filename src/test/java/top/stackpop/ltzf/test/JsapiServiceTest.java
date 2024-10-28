package top.stackpop.ltzf.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import top.stackpop.ltzf.factory.Configuration;
import top.stackpop.ltzf.factory.defaults.DefaultPayFactory;
import top.stackpop.ltzf.payments.jsapi.model.PrepayRequest;
import top.stackpop.ltzf.payments.jsapi.model.PrepayResponse;
import top.stackpop.ltzf.payments.jsapi.model.QueryOrderByOutTradeNoRequest;
import top.stackpop.ltzf.payments.jsapi.model.QueryOrderByOutTradeNoResponse;
import top.stackpop.ltzf.payments.jsapi.JsapiPayService;

import java.io.IOException;

/**
 * @author zbq
 * @date 2024/10/19 21:29
 */
@Slf4j
public class JsapiServiceTest {
    private Configuration configuration;

    private JsapiPayService jsapiPayService;

    @Before
    public void init(){
        this.configuration=new Configuration("aaa","bbb");
        DefaultPayFactory factory = new DefaultPayFactory(configuration);
        this.jsapiPayService = factory.getJsapiPayService();

    }

    @Test
    public void test() throws IOException {
        PrepayRequest request=new PrepayRequest();
        request.setMchId("1695554857");
        request.setOutTradeNo("NO202410192113");
        request.setTotalFee("0.01");
        request.setBody("huawei p70");
        request.setNotifyUrl("http://www.stackpop.top");
        PrepayResponse response = jsapiPayService.prepay(request);
        log.info("请求信息:{}",request);
        log.info("响应结果:{}",response);
    }

    @Test
    public void queryOrder() throws IOException {
        QueryOrderByOutTradeNoRequest request=new QueryOrderByOutTradeNoRequest();
        request.setMchId("1695554857");
        request.setOutTradeNo("NO202410192113");
        QueryOrderByOutTradeNoResponse response = jsapiPayService.getPayOrder(request);
        log.info("请求信息:{}", JSON.toJSONString(request));
        log.info("响应结果:{}",JSON.toJSONString(response));
    }
}
