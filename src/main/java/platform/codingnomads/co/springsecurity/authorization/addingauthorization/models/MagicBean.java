package platform.codingnomads.co.springsecurity.authorization.addingauthorization.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "magic_bean")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MagicBean {

    @Id
    @GeneratedValue
    private long id;

    private String role;

    private String user;

    private String colour;

    private String url;
}
