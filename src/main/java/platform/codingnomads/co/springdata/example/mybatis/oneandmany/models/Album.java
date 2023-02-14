package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Album {

    private long id;

    private String name;

    private long year;

    private Artist artist;

    private List<Song> songs;
}
