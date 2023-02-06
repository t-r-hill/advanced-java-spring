package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Computer computer;

    public SpringDeveloper(Address address, Computer computer) {

        this.address = address;
        this.computer = computer;
    }
}
