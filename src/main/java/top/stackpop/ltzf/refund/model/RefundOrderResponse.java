package top.stackpop.ltzf.refund.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zbq
 * @date 2024/10/18 21:02
 */
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundOrderResponse {
    private Integer code;
    private Data data;
    private String msg;
    @JsonProperty("request_id")
    private String requestId;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        @JsonProperty("mch_id")
        private String mchId;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("out_refund_no")
        private String outRefundNo;
        @JsonProperty("order_no")
        private String orderNo;
        @JsonProperty("pay_refund_no")
        private String payRefundNo;
    }
}
