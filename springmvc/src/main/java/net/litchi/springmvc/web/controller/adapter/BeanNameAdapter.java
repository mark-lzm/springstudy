package net.litchi.springmvc.web.controller.adapter;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 12:22
 */
public class BeanNameAdapter implements Adapter{
    @Override
    public Boolean support(Object controller) {
        return controller instanceof BeanNameController;
    }

    @Override
    public void handler(Object controller) {
        BeanNameController controller1 = (BeanNameController) controller;
        controller1.doBeanNameController();
    }
}
