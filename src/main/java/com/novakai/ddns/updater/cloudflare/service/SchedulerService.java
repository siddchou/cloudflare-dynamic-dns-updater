package com.novakai.ddns.updater.cloudflare.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SchedulerService {

    private final Logger logger= LoggerFactory.getLogger(SchedulerService.class);

    @Autowired
    private UpdaterService updaterService;

    @Scheduled(fixedDelayString = "${fixedDelay.in.minutes}" , timeUnit = TimeUnit.MINUTES)
    public void scheduleFixedRateWithInitialDelayTask() {
        logger.info("Starting scheduler <-----------  For updating DNS settings      ------->");
        if(updaterService.processForDNSRecordUpdate()){
        logger.info("SUCCESS record has been updated to new IP");
        }else{
            logger.info("No record is updated ");
        }

    }
}
