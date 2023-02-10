package platform.codingnomads.co.springdata.example.ddl.manytomany.jointableexample;

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
    @JoinTable(
            name = "tagged_users_photos",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id")
    )
    private List<Photo> taggedPhotos;
}
