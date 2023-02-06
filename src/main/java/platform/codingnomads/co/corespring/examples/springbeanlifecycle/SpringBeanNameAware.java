package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanNameAware implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("Say my name three times! " + name + " " + name + " " + name);
    }
}
