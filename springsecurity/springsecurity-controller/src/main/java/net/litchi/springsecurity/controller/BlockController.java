package net.litchi.springsecurity.controller;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/7 20:58
 */

import lombok.extern.slf4j.Slf4j;
import net.litchi.springsecurity.controller.mock.block.DeferredResultHolder;
import net.litchi.springsecurity.controller.mock.block.MockQueue;
import net.litchi.springsecurity.util.JSONResult;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * 演示阻塞与非阻塞模型
 * 阻塞也可以开多线程
 */
@RestController
@RequestMapping("/block")
@Slf4j
public class BlockController {
    /*
    @GetMapping
    public Callable<JSONResult> showBlock() throws InterruptedException {

        long begin = System.currentTimeMillis();
        log.info("main thread start at {}", begin);

        Callable<JSONResult> callable = new Callable<JSONResult>() {
            @Override
            public JSONResult call() throws Exception {
                long begin = System.currentTimeMillis();
                log.info("sub thread start at {}", begin);

                Thread.sleep(1000);
                long end = System.currentTimeMillis();
                log.info("sub thread end at {} and cost {} milsec", end, end - begin);

                return JSONResult.ok();
            }
        };

        long end = System.currentTimeMillis();
        log.info("main thread end at {} and cost {} milsec", end, end - begin);
        return callable;

    }
    */

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @GetMapping
    public DeferredResult<JSONResult> getOrders(){

        log.info("主线程开始");
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<JSONResult> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber,result);

        log.info("主线程结束");
        return result;
    }
}
