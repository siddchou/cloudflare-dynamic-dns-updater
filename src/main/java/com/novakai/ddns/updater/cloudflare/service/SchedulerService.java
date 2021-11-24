package com.novakai.ddns.updater.cloudflare.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    private final Logger logger= LoggerFactory.getLogger(SchedulerService.class);

    @Autowired
    private UpdaterService updaterService;

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void scheduleFixedRateWithInitialDelayTask() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "Fixed rate task with one second initial delay - " + now);
        if(updaterService.processForDNSRecordUpdate()){
        logger.info("SUCCESS record has been updated to new IP");
        }else{
            logger.info("No record is updated ");
        }

    }
}
