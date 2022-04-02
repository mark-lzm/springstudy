package net.litchi.spring.ioc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 20:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Orders {
    private Integer id;
    private Integer userId;
    private String number;
    private Date createtime;
    private String note;

    private User user;

    private List<OrderDetail> orderDetails;
}
