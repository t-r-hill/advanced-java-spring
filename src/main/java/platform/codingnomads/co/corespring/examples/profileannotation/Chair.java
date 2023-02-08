package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
public class Chair {

    @Value("${deploy.time}")
    private Integer time;

    public Chair(){
        System.out.println("Chair is being sat on");
    }

    public Integer getTime(){
        return time;
    }
}
