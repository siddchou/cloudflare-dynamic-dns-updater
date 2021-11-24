package com.novakai.ddns.updater.cloudflare.service;

import com.novakai.ddns.updater.cloudflare.domain.Request;
import com.novakai.ddns.updater.cloudflare.domain.Result;
import com.novakai.ddns.updater.cloudflare.domain.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CloudFlareService {

    private final Logger logger= LoggerFactory.getLogger(CloudFlareService.class);

    @Value("${cloudflare.url.getByZoneAndType}")
    private String cloudflareURlgetByZoneAndType;
    @Value("${cloudflare.url.updateDnsRecordUrl}")
    private String cloudflareUpdateDnsRecordUrl;
    @Value("${cloudflare.authEmail}")
    private String authEmail;
    @Value("${cloudflare.key}")
    private String authKey;
    public List<Result> fetchDNSARecords(){
        logger.info("Inside CloudFlareService.fetchDNSARecords");
        List<Result> resultList= new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        headers.add("X-Auth-Key",authKey);
        headers.add("X-Auth-Email",authEmail);

        final HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Root> response = restTemplate.exchange(cloudflareURlgetByZoneAndType, HttpMethod.GET, entity, Root.class);
        logger.info("Status of request  {}",response.getStatusCodeValue());
        Optional.ofNullable(response.getBody().getResult()).ifPresent(resultList::addAll);
        return resultList;
    }



    public boolean makeApiCallToUpdateDNS(Map<String, Request> updateRequestJson) {
        boolean returnCode;
        try{
            updateRequestJson.forEach(this::makeApiCall);
            returnCode=true;
        }catch (Exception e){
            returnCode =false;
        }
        return returnCode;
    }

    private void makeApiCall(String recordId, Request value) {

        logger.info("Inside CloudFlareService.makeApiCall");

        RestTemplate restTemplate = new RestTemplate();
        String  updateUrl=cloudflareUpdateDnsRecordUrl+recordId;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        headers.add("X-Auth-Key",authKey);
        headers.add("X-Auth-Email",authEmail);

        final HttpEntity<Request> entity = new HttpEntity<>(value,headers);
        ResponseEntity<Map> response = restTemplate.exchange(updateUrl, HttpMethod.PUT, entity, Map.class);
        logger.info("Status of request  {}",response.getStatusCodeValue());
        logger.info("Response {}",response.getBody());

    }

}
