package net.litchi.spring.aop.reflect;

import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 10:29
 */
public class JdkProxyProcessor implements InvocationHandler {

    private Object target;
    private String interceptorName;

    public JdkProxyProcessor(Object target) {
        this.target = target;
    }

    public JdkProxyProcessor() {
    }

    public JdkProxyProcessor(Object target, String interceptorName) {
        this.target = target;
        this.interceptorName = interceptorName;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /*if(method.getName().endsWith("add")){
            return 1;
        }*/
//        System.out.println("before");
//
//        System.out.println(method.getName());
//        System.out.println(Arrays.toString(args));

//        System.out.println("after");

        Object result = null;

        if (StringUtils.isEmpty(interceptorName)) {
            result = method.invoke(target, args);


            System.out.println(new Date() + "使用了:"
                    + Arrays.toString(args)
                    + "作为参数，" + "调用了"
                    + method.getName() + "方法，"
                    + "得到了" + result + "结果");

        } else {
            Interceptor interceptor = (Interceptor) Class.forName(interceptorName).getDeclaredConstructor().newInstance();
            try {
                if (interceptor.before(target, proxy, method, args)) {
                    result = interceptor.around(target, proxy, method, args);
                    interceptor.afterReturning(target, proxy, method, args, result);
                }else {
                    throw new RuntimeException("before method invoke exception");
                }
            } catch (Exception e) {
                interceptor.afterThrowing(target, proxy, method, args, e);
            }finally {
                interceptor.after(target, proxy, method, args);
            }


        }
        return result;
    }
}
