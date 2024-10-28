package top.stackpop.ltzf.payments.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zbq
 * @date 2024/10/19 18:17
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
        private String appid;
        private String partnerid;
        private String prepayid;
        @JsonProperty("package")
        private String package_field;
        private String noncestr;
        private String timestamp;
        private String sign;
    }
}
