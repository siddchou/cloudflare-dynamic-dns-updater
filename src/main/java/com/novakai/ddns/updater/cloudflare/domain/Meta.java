package com.novakai.ddns.updater.cloudflare.domain;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class Meta {
    boolean auto_added;
    boolean managed_by_apps;
    boolean managed_by_argo_tunnel;
    String source;
}
