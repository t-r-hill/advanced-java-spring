package platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String username;

    @ManyToMany
    private List<Photo> taggedPhotos;
}
