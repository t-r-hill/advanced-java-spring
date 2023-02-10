package platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "photos")
@NoArgsConstructor
@Getter
@Setter
public class Photo {

    @Id
    @GeneratedValue
    private long id;

    private String url;

    @ManyToMany(mappedBy = "taggedPhotos")
    private List<User> taggedUsers;
}
