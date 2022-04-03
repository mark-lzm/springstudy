package net.litchi.springmvc.web.controller.adapter;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 12:29
 */
public class XxxControllerAdapter implements Adapter{
    @Override
    public Boolean support(Object controller) {
        return controller instanceof XxxController;
    }

    @Override
    public void handler(Object controller) {
        XxxController controller1 = (XxxController) controller;
        controller1.doXxxController();
    }
}