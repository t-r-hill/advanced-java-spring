package platform.codingnomads.co.corespring.examples.dependsonannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringDeveloper {
    @Autowired
    private JDK jdk;

    @Autowired
    private Coffee coffee;

    public SpringDeveloper() {
        System.out.println("SpringDeveloper is ready.");
    }
}
