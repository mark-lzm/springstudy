package net.litchi.springboot.web.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.litchi.springboot.service.AsyncService;
import net.litchi.springboot.util.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/5 17:10
 */
@RestController
@AllArgsConstructor
@RequestMapping("/async")
@Slf4j
public class AsyncController {
    private AsyncService asyncService;

    @GetMapping
    public JSONResult getAsync() throws InterruptedException, ExecutionException {
        long begin = System.currentTimeMillis();
        log.info("start at" + begin);

        Future<Boolean> booleanFuture1 = asyncService.task1();
        Future<Boolean> booleanFuture2 = asyncService.task2();
        Future<Boolean> booleanFuture3 = asyncService.task3();

        while (!booleanFuture1.isDone() || !booleanFuture2.isDone() || !booleanFuture3.isDone()) {
            if (booleanFuture1.isDone() && booleanFuture2.isDone() && booleanFuture3.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();
        log.info("end at {} cost {} ms", end, end - begin);

        return JSONResult.ok(booleanFuture1.get() && booleanFuture2.get() && booleanFuture3.get());
    }
}
