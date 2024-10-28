package top.stackpop.ltzf.refund.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import top.stackpop.ltzf.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zbq
 * @date 2024/10/18 21:02
 */
@Data
public class RefundOrderRequest {
    @JsonProperty("mch_id")
    private String mchId;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    @JsonProperty("out_refund_no")
    private String outRefundNo;
    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);
    @JsonProperty("refund_fee")
    private String refundFee;
    @JsonProperty("refund_desc")
    private String refundDesc;
    @JsonProperty("notify_url")
    private String notifyUrl;

    public String createSign(String partnerKey) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", mchId);
        dataMap.put("out_trade_no", outTradeNo);
        dataMap.put("out_refund_no", outRefundNo);
        dataMap.put("timestamp", timestamp);
        dataMap.put("refund_fee", refundFee);
        return SignUtils.createSign(dataMap, partnerKey);

    }


}
