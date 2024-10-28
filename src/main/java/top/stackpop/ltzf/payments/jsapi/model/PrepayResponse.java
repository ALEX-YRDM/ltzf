package top.stackpop.ltzf.payments.jsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author zbq
 * @date 2024/10/19 17:54
 */
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrepayResponse {
    private Integer code;
    private Data data;
    private String msg;
    @JsonProperty("request_id")
    private String requestId;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private String appId;
        private String timeStamp;
        private String nonceStr;
        @JsonProperty("package")
        private String package_field;
        private String signType;
        private String paySign;
    }
}
