package top.stackpop.ltzf.payments.h5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author zbq
 * @date 2024/10/18 22:42
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrepayResponse {
    private Integer code;
    private String data;
    private String msg;
    @JsonProperty("request_id")
    private String requestId;
}
