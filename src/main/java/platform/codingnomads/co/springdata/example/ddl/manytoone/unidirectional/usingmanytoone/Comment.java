package platform.codingnomads.co.springdata.example.ddl.manytoone.unidirectional.usingmanytoone;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Post post;
}
