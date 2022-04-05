package net.litchi.springboot.web.advice;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/5 16:53
 */

import lombok.extern.slf4j.Slf4j;
import net.litchi.springboot.util.JSONResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 处理统一异常的Handler
 */
//@ControllerAdvice
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public JSONResult handleException(Exception e){
        return JSONResult.errorException(e.getLocalizedMessage());
    }

    @ExceptionHandler(ArithmeticException.class)
    public JSONResult handleException(ArithmeticException e){
        return JSONResult.errorException("算术异常");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //@ResponseBody
    public JSONResult handleException1(Exception e){
        log.error("Default Exception : ", e);
        return JSONResult.errorException(e.getLocalizedMessage());
    }

}
