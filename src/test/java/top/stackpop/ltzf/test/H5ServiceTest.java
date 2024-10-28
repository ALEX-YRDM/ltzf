package top.stackpop.ltzf.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import top.stackpop.ltzf.factory.Configuration;
import top.stackpop.ltzf.factory.defaults.DefaultPayFactory;
import top.stackpop.ltzf.payments.h5.H5PayService;
import top.stackpop.ltzf.payments.h5.model.PrepayRequest;
import top.stackpop.ltzf.payments.h5.model.PrepayResponse;
import top.stackpop.ltzf.payments.h5.model.QueryOrderByOutTradeNoRequest;
import top.stackpop.ltzf.payments.h5.model.QueryOrderByOutTradeNoResponse;

import java.io.IOException;

/**
 * @author zbq
 * @date 2024/10/19 18:26
 */
@Slf4j
public class H5ServiceTest {
    private Configuration configuration;

    private H5PayService h5PayService;

    @Before
    public void init(){
        this.configuration=new Configuration("aaa","bbb");
        DefaultPayFactory factory = new DefaultPayFactory(configuration);
        this.h5PayService = factory.getH5PayService();

    }

    @Test
    public void test() throws IOException {
        PrepayRequest request=new PrepayRequest();
        request.setMchId("1695554857");
        request.setOutTradeNo("NO202410192113");
        request.setTotalFee("0.01");
        request.setBody("huawei p70");
        request.setNotifyUrl("http://www.stackpop.top");
        PrepayResponse response = h5PayService.prepay(request);
        //请求信息:PrepayRequest(mchId=1695554857, outTradeNo=NO202410192113, totalFee=0.01, body=huawei p70, timestamp=1729343996, notifyUrl=http://www.stackpop.top, returnUrl=null, attach=null, timeExpire=null, developerAppid=null)
        //[main] INFO top.stackpop.ltzf.test.H5ServiceTest - 响应结果:PrepayResponse(code=0, data=https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=wx19211957524323b22c36650b9834eb0000&package=91367652, msg=微信H5下单成功, requestId=95e0540c-1c85-8983-5974-d8856f388c6b)
        log.info("请求信息:{}",request);
        log.info("响应结果:{}",response);
    }

    @Test
    public void queryOrder() throws IOException {
        QueryOrderByOutTradeNoRequest request=new QueryOrderByOutTradeNoRequest();
        request.setMchId("1695554857");
        request.setOutTradeNo("NO202410192113");
        QueryOrderByOutTradeNoResponse response = h5PayService.getPayOrder(request);
        //请求信息:{"mch_id":"1695554857","out_trade_no":"NO202410192113","timestamp":"1729344167"}
        //[main] INFO top.stackpop.ltzf.test.H5ServiceTest - 响应结果:{"code":0,"data":{"add_time":"2024-10-19 21:19:57","attach":"","body":"huawei p70","mch_id":"1695554857","order_no":"WX202410192119574703938418","out_trade_no":"NO202410192113","pay_status":0,"total_fee":"0.01","trade_type":"H5"},"msg":"查询成功","request_id":"ba425535-f96c-215d-70dd-77011c98ecf0"}
        log.info("请求信息:{}", JSON.toJSONString(request));
        log.info("响应结果:{}",JSON.toJSONString(response));
    }
}
