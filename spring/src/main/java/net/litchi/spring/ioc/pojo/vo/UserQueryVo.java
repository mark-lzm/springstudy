package net.litchi.spring.ioc.pojo.vo;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.litchi.spring.ioc.pojo.User;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 16:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class  UserQueryVo extends User {
    private List<Integer> ids;
}
