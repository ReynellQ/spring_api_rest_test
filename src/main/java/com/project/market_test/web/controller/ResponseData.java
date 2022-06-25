package com.project.market_test.web.controller;

public class ResponseData {
    private boolean status;
    private Object msg;

    public ResponseData(boolean status, Object msg) {
        this.status = status;
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
