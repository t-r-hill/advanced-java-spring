package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class Token {
    private long id;
    private long maxSupply;
    private String name;
    private String symbol;

    public Token(long id, String name, String symbol, long maxSupply){
        this.id = id;
        this.maxSupply = maxSupply;
        this.name = name;
        this.symbol = symbol;
    }
}
