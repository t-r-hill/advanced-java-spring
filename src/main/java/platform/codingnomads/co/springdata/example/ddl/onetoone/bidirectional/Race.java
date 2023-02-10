package platform.codingnomads.co.springdata.example.ddl.onetoone.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "races")
@NoArgsConstructor
@Getter
@Setter
public class Race {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private long laps;

    @OneToOne(mappedBy = "race")
    private Car car;
}
