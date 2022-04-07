package net.litchi.springsecurity.controller.mock.block;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/7 21:19
 */
@Slf4j
@Component
public class MockQueue {
    /**
     * 订单号
     * 如果有值，表示有待处理的订单
     */
    private String placeOrder;

    /**
     * 如果有值，表示订单已完成
     */
    private String complateOrder;

    public void setPlaceOrder(String placeOrder){
        new Thread(()->{
            log.debug("接收到订单请求，应用二正在处理订单信息");
            try {
                Thread.sleep(1000);
                this.complateOrder = placeOrder;
                log.debug("应用二，订单处理完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public String getPlaceOrder() {
        return placeOrder;
    }

    public String getComplateOrder() {
        return complateOrder;
    }

    public void setComplateOrder(String complateOrder) {
        this.complateOrder = complateOrder;
    }
}
