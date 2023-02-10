package platform.codingnomads.co.springdata.example.ddl.manytoone.unidirectional.usingmanytoone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table()
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Comment> comments;

}
