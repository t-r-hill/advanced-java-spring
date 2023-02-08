package platform.codingnomads.co.corespring.lab;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Bicycle {


    private String manufacturer;

    private Integer size;

    private Integer jazziness;

    public void howJazzyIsMyBike(){
        System.out.println("My bike is this jazzy: " + jazziness);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getJazziness() {
        return jazziness;
    }
}
