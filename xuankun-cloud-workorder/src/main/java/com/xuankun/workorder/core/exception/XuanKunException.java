package com.xuankun.workorder.core.exception;

/**
 * @author Jimy
 * @Title: XuanKunException
 * @Package com.xuankun.workorder.core.exception
 * @Description: todo
 * @date 2022/10/19:17:21
 */
public class XuanKunException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public XuanKunException(int code) {
        this.code = code;
        this.msg = null;
    }

    public XuanKunException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public XuanKunException(int code, Throwable e) {
        super(e);
        this.code = code;
        this.msg = e.getMessage();
    }

    public XuanKunException(String msg) {
        super(msg);
        this.code = 500;
        this.msg = msg;
    }

    public XuanKunException(String msg, Throwable e) {
        super(msg, e);
        this.code = 500;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
