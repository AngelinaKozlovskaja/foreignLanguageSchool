package com.kozlovskaya.web.controller;

import com.kozlovskaya.web.entities.Request;

public class RequestBoolean {
    private Request request;

    private Boolean accept = Boolean.FALSE;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Boolean getAccept() {
        return accept;
    }

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

    public RequestBoolean(Request request, Boolean accept) {

        this.request = request;
        this.accept = accept;
    }
}
