package com.chf.core.domain;

public class Resp {

    private String msg;

    private int code;

    public Resp(String msg) {
        this.msg = msg;
        this.code = 200;
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
