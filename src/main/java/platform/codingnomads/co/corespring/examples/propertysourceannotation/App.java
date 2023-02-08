package platform.codingnomads.co.corespring.examples.propertysourceannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class App {
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${property.one}")
    private Integer propertyOne;

    @Value("${property.two}")
    private Integer propertyTwo;

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public Integer getPropertyOne() {
        return propertyOne;
    }

    public Integer getPropertyTwo() {
        return propertyTwo;
    }
}
