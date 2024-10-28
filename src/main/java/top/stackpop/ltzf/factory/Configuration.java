package top.stackpop.ltzf.factory;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author zbq
 * @date 2024/10/18 16:33
 */
@Getter
public class Configuration {
    //请求地址
    private String apiHost = "https://api.ltzf.cn/";
    //商户号
    private final String mchId;
    //开发者id
    private String appid;
    //商户密钥
    private final String partnerKey;

    public Configuration(String mchId, String partnerKey) {
        this.mchId = mchId;
        this.partnerKey = partnerKey;
    }

    public Configuration(String mchId, String appid, String partnerKey) {
        this.mchId = mchId;
        this.appid = appid;
        this.partnerKey = partnerKey;
    }

    //okhttp客户端
    @Setter
    private OkHttpClient okHttpClient;
    //日志级别
    @Setter
    private HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.HEADERS;
    @Setter
    private long connectTimeout = 60;
    @Setter
    private long writeTimeout = 60;
    @Setter
    private long readTimeout = 60;
}
