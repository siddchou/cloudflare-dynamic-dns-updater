package com.novakai.ddns.updater.cloudflare.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Root {
    @JsonProperty("result")
    public List<Result> getResult() {
        return this.result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    List<Result> result;

    @JsonProperty("success")
    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    boolean success;

    @JsonProperty("errors")
    public List<Object> getErrors() {
        return this.errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    List<Object> errors;

    @JsonProperty("messages")
    public List<Object> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Object> messages) {
        this.messages = messages;
    }

    List<Object> messages;

    @JsonProperty("result_info")
    public ResultInfo getResult_info() {
        return this.result_info;
    }

    public void setResult_info(ResultInfo result_info) {
        this.result_info = result_info;
    }

    ResultInfo result_info;
}
