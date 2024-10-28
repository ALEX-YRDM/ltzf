package top.stackpop.ltzf.payments.h5Jump.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zbq
 * @date 2024/10/19 17:40
 */
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryOrderByOutTradeNoResponse {

    private Integer code;

    private Data data;

    private String msg;

    @JsonProperty("request_id")
    private String requestId;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {

        @JsonProperty("add_time")
        private String addTime;

        @JsonProperty("mch_id")
        private String mchId;

        @JsonProperty("order_no")
        private String orderNo;

        @JsonProperty("out_trade_no")
        private String outTradeNo;

        @JsonProperty("pay_no")
        private String payNo;

        private String body;

        @JsonProperty("total_fee")
        private String totalFee;

        @JsonProperty("trade_type")
        private String tradeType;

        @JsonProperty("success_time")
        private String successTime;

        private String attach;

        private String openid;

        @JsonProperty("pay_status")
        private Integer payStatus;
    }
}

