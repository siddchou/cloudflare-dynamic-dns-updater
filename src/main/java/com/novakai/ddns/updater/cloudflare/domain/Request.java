package com.novakai.ddns.updater.cloudflare.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {


    @JsonProperty("type")
    String type;

    @JsonProperty("name")
    String name;

    @JsonProperty("content")
    String content;

    @JsonProperty("ttl")
    int ttl;

    @JsonProperty("proxied")
    boolean proxied;

    public String getType() {
        return type;
    }

    public Request(String type, String name, String content, int ttl, boolean proxied) {
        this.type = type;
        this.name = name;
        this.content = content;
        this.ttl = ttl;
        this.proxied = proxied;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public boolean isProxied() {
        return proxied;
    }

    public void setProxied(boolean proxied) {
        this.proxied = proxied;
    }
}
