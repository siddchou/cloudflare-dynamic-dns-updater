package com.novakai.ddns.updater.cloudflare.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultInfo {
    @JsonProperty("page")
    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    int page;

    @JsonProperty("per_page")
    public int getPer_page() {
        return this.per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    int per_page;

    @JsonProperty("count")
    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    int count;

    @JsonProperty("total_count")
    public int getTotal_count() {
        return this.total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    int total_count;

    @JsonProperty("total_pages")
    public int getTotal_pages() {
        return this.total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    int total_pages;
}
