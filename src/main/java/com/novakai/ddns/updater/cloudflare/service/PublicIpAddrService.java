package com.novakai.ddns.updater.cloudflare.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;

@Service
public class PublicIpAddrService {
    private final Logger logger= LoggerFactory.getLogger(PublicIpAddrService.class);
    @Value("${public.ip.url}")
    private String url;
    @Value("${public.ip.scheme}")
    private String scheme;

    public String fetchPublicIpaddress () throws UnknownHostException {
        logger.info("trying to find publicIp Address");
        RestTemplate restTemplate = new RestTemplate();
        String publicIpaddressUrl = scheme.trim()+"://"+url.trim();
        ResponseEntity<String> response
                = restTemplate.getForEntity(publicIpaddressUrl, String.class);
        logger.info("response for public ip Address {}",response.getBody());
        return response.getBody();
    }
}
