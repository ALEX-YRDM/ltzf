package top.stackpop.ltzf.payments.nativepay;

import lombok.Data;
import retrofit2.Call;
import retrofit2.Response;
import top.stackpop.ltzf.factory.Configuration;
import top.stackpop.ltzf.payments.nativepay.model.*;
import top.stackpop.ltzf.refund.model.GetRefundOrderRequest;
import top.stackpop.ltzf.refund.model.GetRefundOrderResponse;
import top.stackpop.ltzf.refund.model.RefundOrderRequest;
import top.stackpop.ltzf.refund.model.RefundOrderResponse;

import java.io.IOException;

/**
 * @author zbq
 * @date 2024/10/18 16:25
 */
@Data
public class NativePayService {

    private final INativePayApi nativePayApi;

    private final Configuration configuration;

    public PrepayResponse prepay(PrepayRequest request) throws IOException {
        //1.请求接口 & 签名
        Call<PrepayResponse> call = nativePayApi.prepay(
                request.getMchId(),
                request.getOutTradeNo(),
                request.getTotalFee(),
                request.getBody(),
                request.getTimestamp(),
                request.getNotifyUrl(),
                request.getAttach(),
                request.getTimeExpire(),
                request.getDeveloperAppid(),
                request.createSign(configuration.getPartnerKey())
        );

        //2.调用
        Response<PrepayResponse> execute = call.execute();

        //3.返回结果
        return execute.body();
    }

    public QueryOrderByOutTradeNoResponse getPayOrder(QueryOrderByOutTradeNoRequest request) throws IOException {
        //1. 获取请求接口
        Call<QueryOrderByOutTradeNoResponse> call = nativePayApi.getPayOrder(
                request.getMchId(),
                request.getOutTradeNo(),
                request.getTimestamp(),
                request.createSign(configuration.getPartnerKey())
        );

        //2.执行
        Response<QueryOrderByOutTradeNoResponse> execute = call.execute();

        //3.返回结果
        return execute.body();

    }




}
