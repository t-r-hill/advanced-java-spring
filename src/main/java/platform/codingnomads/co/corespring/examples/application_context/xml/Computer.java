package platform.codingnomads.co.corespring.examples.application_context.xml;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Computer {
    public String make;
    public String model;
    public String processor;
    public int ram;
}
