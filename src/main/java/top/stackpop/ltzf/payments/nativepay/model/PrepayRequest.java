package top.stackpop.ltzf.payments.nativepay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import top.stackpop.ltzf.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 扫描支付请求对象
 *
 * @author zbq
 * @date 2024/10/18 16:09
 */
@Data
public class PrepayRequest {
    @JsonProperty("mch_id")
    private String mchId;

    @JsonProperty("out_trade_no")
    private String outTradeNo;

    @JsonProperty("total_fee")
    private String totalFee;

    @JsonProperty("body")
    private String body;

    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

    @JsonProperty("notify_url")
    private String notifyUrl;

    private String attach;

    @JsonProperty("time_expire")
    private String timeExpire;

    @JsonProperty("developer_appid")
    private String developerAppid;


    public String createSign(String partnerKey) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", mchId);
        dataMap.put("out_trade_no", outTradeNo);
        dataMap.put("total_fee", totalFee);
        dataMap.put("body", body);
        dataMap.put("timestamp", timestamp);
        dataMap.put("notify_url", notifyUrl);
        return SignUtils.createSign(dataMap, partnerKey);

    }

}
