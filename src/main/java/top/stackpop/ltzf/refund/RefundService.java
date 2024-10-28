package top.stackpop.ltzf.refund;

import lombok.Data;
import retrofit2.Call;
import retrofit2.Response;
import top.stackpop.ltzf.factory.Configuration;
import top.stackpop.ltzf.refund.model.GetRefundOrderRequest;
import top.stackpop.ltzf.refund.model.GetRefundOrderResponse;
import top.stackpop.ltzf.refund.model.RefundOrderRequest;
import top.stackpop.ltzf.refund.model.RefundOrderResponse;

import java.io.IOException;

/**
 * @author zbq
 * @date 2024/10/19 13:23
 */
@Data
public class RefundService {

    private final IRefundApi refundApi;
    private final Configuration configuration;

    public RefundOrderResponse refundOrder(RefundOrderRequest request) throws IOException {
        //1.获取请求接口
        Call<RefundOrderResponse> call = refundApi.refundOrder(
                request.getMchId(),
                request.getOutTradeNo(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.getRefundFee(),
                request.getRefundDesc(),
                request.getNotifyUrl(),
                request.createSign(configuration.getPartnerKey())
        );

        //2.执行请求
        Response<RefundOrderResponse> execute = call.execute();
        //3.响应结果
        return execute.body();
    }

    public GetRefundOrderResponse getRefundOrder(GetRefundOrderRequest request) throws IOException {
        //1.获取请求接口
        Call<GetRefundOrderResponse> call = refundApi.getRefundOrder(
                request.getMchId(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.createSign(configuration.getPartnerKey())
        );
        //2.发起请求
        Response<GetRefundOrderResponse> execute = call.execute();
        //3.响应结果
        return execute.body();
    }
}
