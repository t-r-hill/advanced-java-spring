package platform.codingnomads.co.corespring.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

    private String manufacturer;

    private Integer topSpeed;

    private Integer streetCred;

    public void isYourCarCool(){
        System.out.println("My car is this cool: " + streetCred);
    }

}
