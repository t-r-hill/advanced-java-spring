package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class House {

    @Id
    @GeneratedValue
    private long id;

    private int numFloors;

    private String type;

    private int numBedrooms;

    @OneToOne
    private Address address;
}
