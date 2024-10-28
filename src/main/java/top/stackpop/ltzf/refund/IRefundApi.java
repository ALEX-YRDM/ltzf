package top.stackpop.ltzf.refund;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import top.stackpop.ltzf.refund.model.GetRefundOrderResponse;
import top.stackpop.ltzf.refund.model.RefundOrderResponse;

/**
 * @author zbq
 * @date 2024/10/19 13:20
 */
public interface IRefundApi {
    @POST("api/wxpay/refund_order")
    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<RefundOrderResponse> refundOrder(
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("out_refund_no") String outRefundNo,
            @Field("timestamp") String timestamp,
            @Field("refund_fee") String refundFee,
            @Field("refund_desc") String refundDesc,
            @Field("notify_url") String notifyUrl,
            @Field("sign") String sign
    );

    @POST("api/wxpay/get_refund_order")
    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<GetRefundOrderResponse> getRefundOrder(
            @Field("mch_id") String mchId,
            @Field("out_refund_no") String outRefundNo,
            @Field("timestamp") String timestamp,
            @Field("sign") String sign
    );
}
