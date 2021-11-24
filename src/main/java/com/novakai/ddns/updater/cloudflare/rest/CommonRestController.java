package com.novakai.ddns.updater.cloudflare.rest;

import com.novakai.ddns.updater.cloudflare.domain.Result;
import com.novakai.ddns.updater.cloudflare.service.CloudFlareService;
import com.novakai.ddns.updater.cloudflare.service.PublicIpAddrService;
import com.novakai.ddns.updater.cloudflare.service.UpdaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CommonRestController {

    @Autowired
    private PublicIpAddrService publicIpAddrService;

    @Autowired
    private UpdaterService updaterService;

    @Autowired
    private CloudFlareService cloudFlareService;

    @GetMapping("/fetchIpAddress")
    public String  fetchIpAddress ()  {
        return publicIpAddrService.fetchPublicIpaddress();

    }

    @GetMapping("/fetchDNSRecord")
    public List<Result> fetchDNSRecord ()  {
        return cloudFlareService.fetchDNSARecords();

    }


    @GetMapping("/updateDNSRecord")
    public Boolean updateDNSRecord ()  {
        return updaterService.processForDNSRecordUpdate();

    }

}
