package com.novakai.ddns.updater.cloudflare.domain;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class Request {
    String type;
    String name;
    String content;
    int ttl;
    boolean proxied;
    public Request(String type, String name, String content, int ttl, boolean proxied) {
        this.type = type;
        this.name = name;
        this.content = content;
        this.ttl = ttl;
        this.proxied = proxied;
    }

}
