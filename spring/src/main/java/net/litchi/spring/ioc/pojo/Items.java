package net.litchi.spring.ioc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 20:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Items {
    private Integer id;
    private String name;
    private Float price;
    private String detail;
    private String pic;
    private Date createtime;

    private OrderDetail orderDetail;

}
