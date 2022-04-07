package net.litchi.springsecurity.controller.mock.block;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.litchi.springsecurity.util.JSONResult;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/7 21:33
 */
@Component
@AllArgsConstructor
@Slf4j
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    private MockQueue mockQueue;
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        new Thread(() -> {
            while (true) {
                if (!StringUtils.isEmpty(mockQueue.getComplateOrder())) {
                    String OrderNumber = mockQueue.getComplateOrder();
                    log.info("监听到应用二完成订单，取出订单号{}，并且返回", OrderNumber);
                    deferredResultHolder.getMap().get(OrderNumber).setResult(JSONResult.ok(OrderNumber));
                    mockQueue.setComplateOrder(null);
                }else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}
