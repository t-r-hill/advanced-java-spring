package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreLabApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ModeOfTransportConfig.class);

        Bicycle myBicycle = applicationContext.getBean(Bicycle.class);

        Car myCar = applicationContext.getBean(Car.class);

        myCar.isYourCarCool();

        myBicycle.howJazzyIsMyBike();
    }
}
