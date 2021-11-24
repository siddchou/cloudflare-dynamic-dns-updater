package com.novakai.ddns.updater.cloudflare.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    @JsonProperty("auto_added")
    public boolean getAuto_added() {
        return this.auto_added;
    }

    public void setAuto_added(boolean auto_added) {
        this.auto_added = auto_added;
    }

    boolean auto_added;

    @JsonProperty("managed_by_apps")
    public boolean getManaged_by_apps() {
        return this.managed_by_apps;
    }

    public void setManaged_by_apps(boolean managed_by_apps) {
        this.managed_by_apps = managed_by_apps;
    }

    boolean managed_by_apps;

    @JsonProperty("managed_by_argo_tunnel")
    public boolean getManaged_by_argo_tunnel() {
        return this.managed_by_argo_tunnel;
    }

    public void setManaged_by_argo_tunnel(boolean managed_by_argo_tunnel) {
        this.managed_by_argo_tunnel = managed_by_argo_tunnel;
    }

    boolean managed_by_argo_tunnel;

    @JsonProperty("source")
    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    String source;
}
