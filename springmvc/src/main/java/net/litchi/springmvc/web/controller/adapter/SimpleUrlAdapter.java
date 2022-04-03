package net.litchi.springmvc.web.controller.adapter;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 12:23
 */
public class SimpleUrlAdapter implements Adapter{
    @Override
    public Boolean support(Object controller) {
        return controller instanceof SimpleUrlController;
    }

    @Override
    public void handler(Object controller) {
        SimpleUrlController controller1 = (SimpleUrlController) controller;
        controller1.doSimpleUrlController();
    }
}
