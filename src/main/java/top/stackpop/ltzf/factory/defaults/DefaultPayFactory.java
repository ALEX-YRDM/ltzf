package top.stackpop.ltzf.factory.defaults;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import top.stackpop.ltzf.factory.Configuration;
import top.stackpop.ltzf.factory.PayFactory;
import top.stackpop.ltzf.payments.app.AppPayService;
import top.stackpop.ltzf.payments.app.IAppPayApi;
import top.stackpop.ltzf.payments.h5.H5PayService;
import top.stackpop.ltzf.payments.h5.IH5PayApi;
import top.stackpop.ltzf.payments.h5Jump.H5JumpPayService;
import top.stackpop.ltzf.payments.h5Jump.IH5JumpApi;
import top.stackpop.ltzf.payments.jsapi.IJsapiPayApi;
import top.stackpop.ltzf.payments.jsapi.JsapiPayService;
import top.stackpop.ltzf.payments.jsapiConvenient.IJsapiConvenientPayApi;
import top.stackpop.ltzf.payments.jsapiConvenient.JsapiConvenientPayService;
import top.stackpop.ltzf.payments.nativepay.INativePayApi;
import top.stackpop.ltzf.payments.nativepay.NativePayService;
import top.stackpop.ltzf.refund.IRefundApi;
import top.stackpop.ltzf.refund.RefundService;

import java.util.concurrent.TimeUnit;

/**
 * @author zbq
 * @date 2024/10/18 16:44
 */
public class DefaultPayFactory implements PayFactory {
    private final Configuration configuration;

    private final OkHttpClient httpClient;


    public DefaultPayFactory(Configuration configuration) {
        this.configuration = configuration;
        //1.日志配置
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(configuration.getLevel());
        //2.开启客户端
        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(configuration.getConnectTimeout(), TimeUnit.SECONDS)
                .writeTimeout(configuration.getWriteTimeout(), TimeUnit.SECONDS)
                .readTimeout(configuration.getReadTimeout(), TimeUnit.SECONDS)
                .build();
    }


    @Override
    public NativePayService getNativePayService() {
        //1.构建API
        INativePayApi nativePayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(INativePayApi.class);

        //2.创建NativePayService实例对象并返回
        NativePayService nativePayService = new NativePayService(nativePayApi, configuration);
        return nativePayService;
    }

    @Override
    public RefundService getRefundService() {
        //1.构建RefundApi
        IRefundApi refundApi=new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IRefundApi.class);

        //2.创建RefundService实例对象并返回
        return new RefundService(refundApi, configuration);

    }

    @Override
    public H5PayService getH5PayService() {
        IH5PayApi h5PayApi =new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IH5PayApi.class);

        return new H5PayService(h5PayApi,configuration);
    }

    @Override
    public H5JumpPayService getH5JumpPayService() {
        IH5JumpApi h5JumpApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IH5JumpApi.class);

        return new H5JumpPayService(h5JumpApi,configuration);
    }

    @Override
    public JsapiPayService getJsapiPayService() {
        IJsapiPayApi jsapiPayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IJsapiPayApi.class);

        return new JsapiPayService(jsapiPayApi,configuration);
    }

    @Override
    public JsapiConvenientPayService getJsapiConvenientPayService() {
        IJsapiConvenientPayApi jsapiConvenientPayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IJsapiConvenientPayApi.class);

        return new JsapiConvenientPayService(jsapiConvenientPayApi,configuration);
    }

    @Override
    public AppPayService getAppPayService() {
        IAppPayApi appPayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IAppPayApi.class);

        return new AppPayService(appPayApi,configuration);
    }
}
