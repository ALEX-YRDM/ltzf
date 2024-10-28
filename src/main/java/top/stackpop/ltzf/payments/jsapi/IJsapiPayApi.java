package top.stackpop.ltzf.payments.jsapi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import top.stackpop.ltzf.payments.jsapi.model.PrepayResponse;
import top.stackpop.ltzf.payments.jsapi.model.QueryOrderByOutTradeNoResponse;

/**
 * @author zbq
 * @date 2024/10/19 18:01
 */
public interface IJsapiPayApi {
    @POST("api/wxpay/jsapi")
    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<PrepayResponse> prepay(@Field("mch_id") String mchId,
                                @Field("out_trade_no") String outTradeNo,
                                @Field("total_fee") String totalFee,
                                @Field("body") String body,
                                @Field("openid") String openid,
                                @Field("timestamp") String timestamp,
                                @Field("notify_url") String notifyUrl,
                                @Field("return_url") String returnUrl,
                                @Field("attach") String attach,
                                @Field("time_expire") String timeExpire,
                                @Field("developer_appid") String developerAppid,
                                @Field("sign") String sign
    );

    @POST("api/wxpay/get_pay_order")
    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<QueryOrderByOutTradeNoResponse> getPayOrder(
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("timestamp") String timestamp,
            @Field("sign") String sign
    );
}
