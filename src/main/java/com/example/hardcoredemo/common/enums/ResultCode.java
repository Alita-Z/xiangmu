package com.example.hardcoredemo.common.enums;

/**
 * @author zsw
 */
public enum ResultCode {

    SUCCESS(0, "成功", "success"),

    NOT_LOGIN(401, "用户未登录", "user.not.login"),
    /**
     * 系统异常，通常catch exception抛出
     */
    ERROR(500, "系统异常", "system.error"),

    FAIL(10000, "失败", "fail"),

    PARAM_ILLEGAL(10001, "参数错误", "param.illegal"),

    PASSWORD_ERROR(10002, "密码错误", "password.error"),

    HEADER_BUILD_ILLEGAL(10003,"Header参数错误","header.build.illegal"),

    NOT_PERMISSION(10004, "用户无权限", "user.not.permission"),

    USER_NOT_EXIST(10005, "用户不存在", "admin.user.not.exist"),

    METHOD_ARGUMENT_NOT_VALID(10006, "参数为空", "param.isNull"),

    WX_LOGIN_FAIL(10007, "微信登录失败", "wx.login.fail"),

    COUPON_INSERT_FAIL(10008,"已添加过类型为【邀请】或者【被邀请】的优惠券","coupon.insert.error"),

    PRIMARY_NULL(10009,"主键ID不能为空","primary.not.Null"),

    USER_EXIST(10010, "用户已存在", "admin.user.exist"),

    USER_LOCK(10011,"用户被锁定","user.lock"),

    ORDER_PAY_ERROR(10012,"订单不支持此类型退款","order.pay.error"),

    ALIPAY_CREATE_QRCODE_EXCEPTION(10013,"获取阿里支付二维码失效"," alipay.create.qrcode.exception"),

    REFUND_PAY_FAIL(10014,"退款失败","refund.pay.fail"),

    LESSON_ALREADY_STAR(10014,"已评价过该课程"," lesson.already.star");


    public Integer code;
    public String msg;
    public String key;

    ResultCode(Integer code, String msg, String key) {
        this.code = code;
        this.msg = msg;
        this.key = key;
    }

}
