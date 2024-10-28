package top.stackpop.ltzf.payments.nativepay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 扫码支付响应对象
 *
 * @author zbq
 * @date 2024/10/18 16:17
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
        @JsonProperty("code_url")
        private String codeUrl;
        @JsonProperty("QRcode_url")
        private String qrcodeUrl;

    }
}



