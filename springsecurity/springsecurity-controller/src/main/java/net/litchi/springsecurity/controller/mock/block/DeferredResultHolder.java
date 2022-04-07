package net.litchi.springsecurity.controller.mock.block;

import lombok.Data;
import net.litchi.springsecurity.util.JSONResult;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/7 21:30
 */
@Component
@Data
public class DeferredResultHolder {
    private Map<String, DeferredResult<JSONResult>> map = new HashMap<>();
}
