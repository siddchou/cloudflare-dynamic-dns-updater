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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CloudFlareService {

    private final Logger logger= LoggerFactory.getLogger(CloudFlareService.class);

    @Value("${cloudflare.url}")
    private String cloudflareUrl;
    @Value("${cloudflare.zoneid}")
    private String cloudflareZoneId;
    @Value("${cloudflare.authEmail}")
    private String authEmail;
    @Value("${cloudflare.key}")
    private String authKey;
    @Value("${cloudflare.scheme}")
    private String cloudflareScheme;

    public List<Result> fetchDNSARecords(){
        logger.info("Inside CloudFlareService.fetchDNSARecords");

        RestTemplate restTemplate = new RestTemplate();
        StringBuilder publicIpaddressUrl= new StringBuilder();
        publicIpaddressUrl.append(cloudflareScheme).append("://").append(cloudflareUrl).append("/zones/").append(cloudflareZoneId).append("/dns_records?type=A");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        headers.add("X-Auth-Key",authKey);
        headers.add("X-Auth-Email",authEmail);

        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Root> response = restTemplate.exchange(publicIpaddressUrl.toString(), HttpMethod.GET, entity, Root.class);
        logger.info("Status of request  {}",response.getStatusCodeValue());
        return response.getBody().getResult();
    }



    public boolean makeApiCallToUpdateDNS(HashMap<String, Request> updateRequestJson) {
        boolean returnCode;
        try{
            updateRequestJson.forEach((key, value)->{
                makeApiCall(key,value);
            });
            returnCode=true;
        }catch (Exception e){
            returnCode =false;
        }
        return returnCode;
    }

    private void makeApiCall(String recordId, Request value) {

        logger.info("Inside CloudFlareService.makeApiCall");

        RestTemplate restTemplate = new RestTemplate();
        StringBuilder publicIpaddressUrl= new StringBuilder();
        publicIpaddressUrl.append(cloudflareScheme).append("://").append(cloudflareUrl).append("/zones/").append(cloudflareZoneId).append("/dns_records/").append(recordId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        headers.add("X-Auth-Key",authKey);
        headers.add("X-Auth-Email",authEmail);

        final HttpEntity<Request> entity = new HttpEntity<>(value,headers);
        ResponseEntity<Map> response = restTemplate.exchange(publicIpaddressUrl.toString(), HttpMethod.PUT, entity, Map.class);
        logger.info("Status of request  {}",response.getStatusCodeValue());
        logger.info("Response {}",response.getBody());

    }

}
