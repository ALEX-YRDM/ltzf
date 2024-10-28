package top.stackpop.ltzf.refund.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import top.stackpop.ltzf.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zbq
 * @date 2024/10/18 21:03
 */
@Data
public class GetRefundOrderRequest {
    @JsonProperty("mch_id")
    private String mchId;
    @JsonProperty("out_refund_no")
    private String outRefundNo;

    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);

    public String createSign(String partnerKey) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", mchId);
        dataMap.put("out_refund_no", outRefundNo);
        dataMap.put("timestamp", timestamp);
        return SignUtils.createSign(dataMap, partnerKey);
    }
}
