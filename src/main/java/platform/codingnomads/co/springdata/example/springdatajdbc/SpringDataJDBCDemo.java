package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {

        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE tokens (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL, symbol VARCHAR(255) NOT NULL, max_supply BIGINT NOT NULL);");
        } catch (Exception e) {
            //nothing
        }

        //create a list of first and last names
        List<Object[]> tokens = Stream.of("Bitcoin BTC 21000000", "Nomad NMD 1000000", "NomadInu NINU 1000000000000")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        //for each first & last name pair insert an Employee into the database
        for (Object[] token : tokens) {
            jdbcTemplate.execute(String.format("INSERT INTO tokens (name, symbol, max_supply) VALUES ('%s','%s', %s)", token[0], token[1], token[2]));
        }

        //query the database for Employees with first name Java
        jdbcTemplate.query(
                        "SELECT id, name, symbol, max_supply FROM tokens WHERE name LIKE 'Nomad%'",
                        (rs, rowNum) -> new Token(rs.getLong("id"), rs.getString("name"), rs.getString("symbol"), rs.getLong("max_supply"))
                )
                //print each found employee to the console
                .forEach(token -> System.out.println(token.toString()));

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE tokens;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE tokens");
    }
}
