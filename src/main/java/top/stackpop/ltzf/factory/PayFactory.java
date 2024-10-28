package top.stackpop.ltzf.factory;

import top.stackpop.ltzf.payments.app.AppPayService;
import top.stackpop.ltzf.payments.h5.H5PayService;
import top.stackpop.ltzf.payments.h5Jump.H5JumpPayService;
import top.stackpop.ltzf.payments.jsapi.JsapiPayService;
import top.stackpop.ltzf.payments.jsapiConvenient.JsapiConvenientPayService;
import top.stackpop.ltzf.payments.nativepay.NativePayService;
import top.stackpop.ltzf.refund.RefundService;

/**
 * 支付工厂
 *
 * @author zbq
 * @date 2024/10/18 16:42
 */
public interface PayFactory {

    NativePayService getNativePayService();

    RefundService getRefundService();

    H5PayService getH5PayService();

    H5JumpPayService getH5JumpPayService();

    JsapiPayService getJsapiPayService();

    JsapiConvenientPayService getJsapiConvenientPayService();

    AppPayService getAppPayService();
}
