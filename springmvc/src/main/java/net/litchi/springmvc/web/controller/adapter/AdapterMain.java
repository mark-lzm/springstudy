package net.litchi.springmvc.web.controller.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 12:25
 */
public class AdapterMain {
    private static List<Adapter> adapters = new ArrayList<>();

    static {
        adapters.add(new SimpleUrlAdapter());
        adapters.add(new BeanNameAdapter());
        adapters.add(new AnnotationAdapter());
        adapters.add(new XxxControllerAdapter());
    }

    public static void main(String[] args) {
        AnnotationController controller = new AnnotationController();
        BeanNameController controller1 = new BeanNameController();
        SimpleUrlController controller2 = new SimpleUrlController();
        XxxController controller3 = new XxxController();

        for (Adapter adapter : adapters) {
            if (adapter.support(controller3)) {
                adapter.handler(controller3);
            }
        }
    }

}
