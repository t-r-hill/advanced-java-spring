package platform.codingnomads.co.springdata.lab.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "checkpoints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "route")
@Builder
public class Checkpoint {

    @Id
    @GeneratedValue
    private long id;

    private int number;

    @ManyToOne
    @JoinColumn(name = "location_area_id")
    private Area location;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

}
