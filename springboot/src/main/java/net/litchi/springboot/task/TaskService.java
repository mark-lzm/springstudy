package net.litchi.springboot.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/5 14:29
 */
@Service
@Slf4j
public class TaskService {

    /*cron生成器，在springboot中只允许6位，年的那一位去掉*/
    @Scheduled(/*fixedRate = 1000,*/ cron = "0 0 0 15 * ?")
    public void showTask() {
        /*springboot 默认情况下使用logback作为日志框架*/
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }

}
