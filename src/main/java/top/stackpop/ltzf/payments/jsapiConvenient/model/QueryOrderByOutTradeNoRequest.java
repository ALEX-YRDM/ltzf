package top.stackpop.ltzf.payments.jsapiConvenient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import top.stackpop.ltzf.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zbq
 * @date 2024/10/19 18:08
 */
@Data
public class QueryOrderByOutTradeNoRequest {

    @JsonProperty("mch_id")
    private String mchId;

    @JsonProperty("out_trade_no")
    private String outTradeNo;

    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);

    public String createSign(String partnerKey) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", mchId);
        dataMap.put("out_trade_no", outTradeNo);
        dataMap.put("timestamp", timestamp);
        return SignUtils.createSign(dataMap, partnerKey);
    }


}
