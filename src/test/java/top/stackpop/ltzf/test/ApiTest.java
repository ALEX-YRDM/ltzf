package top.stackpop.ltzf.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import top.stackpop.ltzf.payments.nativepay.INativePayApi;
import top.stackpop.ltzf.payments.nativepay.model.PrepayResponse;
import top.stackpop.ltzf.utils.SignUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zbq
 * @date 2024/10/16 14:58
 */
@Slf4j
@Deprecated
public class ApiTest {

    @Test
    public void test_retrofit2() throws IOException {
        OkHttpClient httpClient=new OkHttpClient();

        INativePayApi nativePayApi = new Retrofit.Builder()
                .baseUrl("https://api.ltzf.cn/")
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(INativePayApi.class);

        long timestamp = System.currentTimeMillis() / 1000;
        System.out.println(timestamp);

        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", "");
        dataMap.put("out_trade_no", "zbq202410162148");
        dataMap.put("total_fee", "0.01");
        dataMap.put("body", "iphone16_promax");
        dataMap.put("timestamp", String.valueOf(timestamp));
        dataMap.put("notify_url", "http://www.stackpop.top" );

        /*Call<PrepayResponse> call = nativePayApi.prepay(dataMap.get("mch_id"),
                dataMap.get("out_trade_no"),
                dataMap.get("total_fee"),
                dataMap.get("body"),
                dataMap.get("timestamp"),
                dataMap.get("notify_url"),
                SignUtils.createSign(dataMap, "91251077870f6bee24e5ab4c37818051"));
        Response<PrepayResponse> response = call.execute();
        PrepayResponse body = response.body();*/

        /*log.info("测试结果:{}", JSON.toJSONString(body));*/
    }
}
