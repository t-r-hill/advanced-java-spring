package platform.codingnomads.co.springdata.example.ddl.manytoone.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reactions")
@NoArgsConstructor
@Getter
@Setter
public class Reaction {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "reaction_type")
    private String reactionType;

    @ManyToOne
    private Post post;
}
