package net.litchi.spring.ioc.pojo.vo;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.litchi.spring.ioc.pojo.User;

import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 16:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
//@SuperBuilder
public class  UserQueryVo extends User {
    private List<Integer> ids;
}
