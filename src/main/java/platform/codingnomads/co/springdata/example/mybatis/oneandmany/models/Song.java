package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Song {

    private Long id;

    private String name;

    private Album album;

    //song length in seconds
    private int songLength;

    public Song(String name, Album album, int songLength) {
        this.name = name;
        this.album = album;
        this.songLength = songLength;
    }
}
