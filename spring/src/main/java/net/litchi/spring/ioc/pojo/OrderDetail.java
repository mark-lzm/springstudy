package net.litchi.spring.ioc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 20:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class OrderDetail implements Serializable {
    private int id;
    private int ordersId;
    private int itemsId;
    private int itemsNum;

    private Orders orders;

    private Items items;
}
