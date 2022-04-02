package net.litchi.spring.ioc.dao;

import net.litchi.spring.ioc.pojo.Orders;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 21:10
 */
public interface OrdersMapper {
    public Orders getOrdersByUserId(String userId);
}
