package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private long id;

    private LocalDateTime orderPlaced;

    private long amount;

}
