package net.litchi.spring.aop.reflect;

import net.litchi.spring.ioc.pojo.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 9:32
 */
public class ReflectMain {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //    Class<User> userClass = User.class;
        /*User user = new User();
        Class aClass = user.getClass();*/

        /*获取jJVM中对于的类的模板*/
        Class<?> aClass1 = Class.forName("net.litchi.spring.ioc.pojo.User");
        User user = (User) aClass1.getDeclaredConstructor().newInstance();
        user.setId("zm");
        user.setPassword("123456");

//        System.out.println(reflectionToString(user));

        /*属性  字段，成员变量*/
        Field[] declaredFields = aClass1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
//            user.getId();
//            ID.getuser
            System.out.println(declaredField.get(user));
        }


        /*方法*/
        Method[] declaredMethods = aClass1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        Method add = aClass1.getDeclaredMethod("add", int.class, int.class);
        System.out.println(add);
        System.out.println(add.invoke(user, 2, 3));

        /*构造器*/
        User o = (User) aClass1.getDeclaredConstructor().newInstance();
        System.out.println(o);

        User o1 = (User) aClass1.getDeclaredConstructor(String.class, String.class).newInstance("2", "123456");
        System.out.println(o1);
        System.out.println(reflectionToString(o1));

    }

    public static String reflectionToString(Object object) throws IllegalAccessException {

        String result = "";
        Class<?> aClass = object.getClass();
        result += aClass.getSimpleName() + "[";

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            result += declaredField.getName() + " : " + declaredField.get(object) + " , ";

        }
        result += "]";
        return result;
    }

}
