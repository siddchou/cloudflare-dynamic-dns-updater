package com.novakai.ddns.updater.cloudflare.service;

import com.novakai.ddns.updater.cloudflare.domain.Request;
import com.novakai.ddns.updater.cloudflare.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class UpdaterService {

    private final Logger logger= LoggerFactory.getLogger(UpdaterService.class);

    @Autowired
    private CloudFlareService cloudFlareService;
    @Value("${cloudflare.domainNames}")
    private String domainNames;

    @Autowired
    private PublicIpAddrService publicIpAddrService;

    public boolean processForDNSRecordUpdate(){
        logger.info("Inside CloudFlareService.updateDNSRecord");
        List<Result> dnsRecords= cloudFlareService.fetchDNSARecords();
        logger.info("DNS records fetched {}",dnsRecords.size());
        List<String> items = Arrays.asList(domainNames.split("\\s*,\\s*"));
        logger.info("DNS Items to be updated  {}",items);
        List<Result> idToBeUpdated= filterIds(dnsRecords,items);
        logger.info("ID to be updated  {}",idToBeUpdated);
        HashMap<String, Request> updateRequestJson= createUpdateRequest(idToBeUpdated);
        if(updateRequestJson.isEmpty()){
            logger.info("Ip change records found {}");
            return false;
        }else{
            logger.info("IP address changed for records {}",updateRequestJson);
           return  cloudFlareService.makeApiCallToUpdateDNS(updateRequestJson);
        }

    }

    private List<Result> filterIds(List<Result> dnsRecords, List<String> items) {
        List<Result> resultList=new ArrayList<>();

        items.forEach(
                item -> {
                    Result record = dnsRecords.stream()
                            .filter(dnsRecord -> item.equals(dnsRecord.getName()))
                            .findAny()
                            .orElse(null);
                    if (record!=null){
                        resultList.add(record);
                    }
                }
        );

        return resultList;
    }

    private HashMap<String,Request> createUpdateRequest(List<Result> resultList) {
        HashMap<String,Request> requestMap=new HashMap<>();
        try {
            String publicIp=publicIpAddrService.fetchPublicIpaddress();
            resultList.forEach(
                    result -> {
                        logger.info("Existing IP Address for record id {} , ip {}",result.getId(),result.getContent());
                        if(!result.getContent().equalsIgnoreCase(publicIp)){
                            logger.info("Different IP found for record id {} , name {}",result.getId(),result.getName());
                            Request request=new Request(result.getType(),result.getName(),publicIp,result.getTtl(),result.getProxied());
                            requestMap.put(result.getId(),request);
                        }
                    }
            );
        } catch (Exception e) {
            logger.info("Issue in finding Public IP address {}" ,e.getMessage());
        }
        return requestMap;
    }
}
