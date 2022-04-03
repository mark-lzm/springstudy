package net.litchi.springmvc.web.controller.adapter;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 12:18
 */
public interface Adapter {
    public Boolean support(Object controller);

    void handler(Object controller);
}
