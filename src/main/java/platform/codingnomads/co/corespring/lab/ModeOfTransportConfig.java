package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/car.xml"})
public class ModeOfTransportConfig {

    @Bean
    public Bicycle bicycle(){
        return new Bicycle("Specialized", 58, 6);
    }
}
