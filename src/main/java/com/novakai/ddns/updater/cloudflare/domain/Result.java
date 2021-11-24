package com.novakai.ddns.updater.cloudflare.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Result {
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    @JsonProperty("zone_id")
    public String getZone_id() {
        return this.zone_id;
    }

    public void setZone_id(String zone_id) {
        this.zone_id = zone_id;
    }

    String zone_id;

    @JsonProperty("zone_name")
    public String getZone_name() {
        return this.zone_name;
    }

    public void setZone_name(String zone_name) {
        this.zone_name = zone_name;
    }

    String zone_name;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    @JsonProperty("content")
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String content;

    @JsonProperty("proxiable")
    public boolean getProxiable() {
        return this.proxiable;
    }

    public void setProxiable(boolean proxiable) {
        this.proxiable = proxiable;
    }

    boolean proxiable;

    @JsonProperty("proxied")
    public boolean getProxied() {
        return this.proxied;
    }

    public void setProxied(boolean proxied) {
        this.proxied = proxied;
    }

    boolean proxied;

    @JsonProperty("ttl")
    public int getTtl() {
        return this.ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    int ttl;

    @JsonProperty("locked")
    public boolean getLocked() {
        return this.locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    boolean locked;

    @JsonProperty("meta")
    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    Meta meta;

    @JsonProperty("created_on")
    public Date getCreated_on() {
        return this.created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    Date created_on;

    @JsonProperty("modified_on")
    public Date getModified_on() {
        return this.modified_on;
    }

    public void setModified_on(Date modified_on) {
        this.modified_on = modified_on;
    }

    Date modified_on;

    @Override
    public String toString() {
        return "Result{" +
                "id='" + id + '\'' +
                ", zone_id='" + zone_id + '\'' +
                ", zone_name='" + zone_name + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", proxiable=" + proxiable +
                ", proxied=" + proxied +
                ", ttl=" + ttl +
                ", locked=" + locked +
                ", meta=" + meta +
                ", created_on=" + created_on +
                ", modified_on=" + modified_on +
                '}';
    }

}
