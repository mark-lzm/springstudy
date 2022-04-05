package net.litchi.springboot.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/5 11:10
 */
public class RedisUtil {

    public static Map getFieldAndValuesMap(Object object) throws IllegalAccessException {
        HashMap<String, String> result = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            result.put(field.getName(), field.get(object) + "");
        }
        return result;
    }
}
