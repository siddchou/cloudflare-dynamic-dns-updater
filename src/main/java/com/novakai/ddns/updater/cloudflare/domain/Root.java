package com.novakai.ddns.updater.cloudflare.domain;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
public class Root {

    List<Result> result;
    boolean success;
    List<Object> errors;
    List<Object> messages;
    ResultInfo result_info;
}
