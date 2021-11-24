package com.novakai.ddns.updater.cloudflare.domain;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class ResultInfo {
    int page;
    int per_page;
    int count;
    int total_count;
    int total_pages;
}
