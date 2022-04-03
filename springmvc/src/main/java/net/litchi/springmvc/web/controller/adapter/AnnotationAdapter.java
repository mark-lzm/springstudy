package net.litchi.springmvc.web.controller.adapter;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 12:19
 */
public class AnnotationAdapter implements Adapter{

    @Override
    public Boolean support(Object controller) {
        return controller instanceof AnnotationController;
    }

    @Override
    public void handler(Object controller) {
        AnnotationController controller1 = (AnnotationController) controller;
        controller1.doAnnotationController();
    }
}
