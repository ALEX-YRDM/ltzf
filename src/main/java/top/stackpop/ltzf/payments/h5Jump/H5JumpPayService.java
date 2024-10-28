package top.stackpop.ltzf.payments.h5Jump;

import lombok.Data;
import retrofit2.Call;
import retrofit2.Response;
import top.stackpop.ltzf.factory.Configuration;
import top.stackpop.ltzf.payments.h5Jump.model.PrepayRequest;
import top.stackpop.ltzf.payments.h5Jump.model.PrepayResponse;
import top.stackpop.ltzf.payments.h5Jump.model.QueryOrderByOutTradeNoRequest;
import top.stackpop.ltzf.payments.h5Jump.model.QueryOrderByOutTradeNoResponse;

import java.io.IOException;

/**
 * @author zbq
 * @date 2024/10/19 17:49
 */
@Data
public class H5JumpPayService {

    private final IH5JumpApi h5JumpApi;
    private final Configuration configuration;

    public PrepayResponse prepay(PrepayRequest request) throws IOException {
        //1.请求接口 & 签名
        Call<PrepayResponse> call = h5JumpApi.prepay(
                request.getMchId(),
                request.getOutTradeNo(),
                request.getTotalFee(),
                request.getBody(),
                request.getTimestamp(),
                request.getNotifyUrl(),
                request.getQuitUrl(),
                request.getReturnUrl(),
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
        Call<QueryOrderByOutTradeNoResponse> call = h5JumpApi.getPayOrder(
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
