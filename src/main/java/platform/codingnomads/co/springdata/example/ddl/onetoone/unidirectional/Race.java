package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

@Entity
@Table(name = "races")
@NoArgsConstructor
@Getter
@Setter
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String city;

    @OneToOne
    private Car car;
}
