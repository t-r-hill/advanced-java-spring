package platform.codingnomads.co.springweb.resttemplate.GET.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ActivityTemplate {

    private long key;

    private String activity;
    private String type;
    private String link;

    private int participants;

    private double price;
    private double accessibility;
}
