package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import platform.codingnomads.co.corespring.examples.profileannotation.SpringDeveloper;

import javax.swing.*;

@Configuration
public class AnotherConfig {

    @Bean("summerdeveloper")
    public SpringDeveloper summerDeveloper(){
        return new SpringDeveloper();
    }
}
