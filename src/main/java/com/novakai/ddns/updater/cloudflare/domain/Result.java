package com.novakai.ddns.updater.cloudflare.domain;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Data
@Jacksonized
public class Result {
    String id;
    String zone_id;
    String zone_name;
    String name;
    String type;
    String content;
    boolean proxiable;
    boolean proxied;
    int ttl;
    boolean locked;
    Meta meta;
    Date created_on;
    Date modified_on;
}
