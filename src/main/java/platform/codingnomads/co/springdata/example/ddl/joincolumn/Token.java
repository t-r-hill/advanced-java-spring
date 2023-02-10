package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tokens")
@NoArgsConstructor
@Getter
@Setter
public class Token {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String symbol;


}
