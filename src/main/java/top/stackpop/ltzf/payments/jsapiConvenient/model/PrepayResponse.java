package top.stackpop.ltzf.payments.jsapiConvenient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zbq
 * @date 2024/10/19 18:07
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


