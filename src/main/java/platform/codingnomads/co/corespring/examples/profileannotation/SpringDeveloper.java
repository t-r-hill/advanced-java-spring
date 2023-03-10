package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class SpringDeveloper {

    @Value("${test.time}")
    private Integer time;

    public SpringDeveloper() {
        System.out.println("SpringDeveloper is ready.");
    }

    public Integer getTime(){
        return time;
    }
}
