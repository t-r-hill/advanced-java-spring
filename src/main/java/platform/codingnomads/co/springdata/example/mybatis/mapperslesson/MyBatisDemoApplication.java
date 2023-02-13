package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "songs_table.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            Song song3 = Song.builder()
                    .name("Shake it off")
                    .album_name("1989")
                    .artist_name("Taylor Swift")
                    .song_length(196).build();

            Song song4 = Song.builder()
                    .name("Blank space")
                    .artist_name("Taylor Swift")
                    .album_name("1989")
                    .song_length(200).build();

            Song song5 = Song.builder()
                    .name("Love story")
                    .artist_name("Taylor Swift")
                    .album_name("Fearless")
                    .song_length(192).build();

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);
            songMapper.insertNewSong(song3);
            songMapper.insertNewSong(song4);
            songMapper.insertNewSong(song5);

            Song song6 = songMapper.getSongById(1L);

            ArrayList<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);

            longSongs.forEach(System.out::println);

            System.out.println(song6.toString());

            songMapper.getSongByNameLike("Shake").forEach(System.out::println);

            songMapper.getSongByLengthLessThan(200).forEach(System.out::println);

            songMapper.deleteSongById(1L);

            songMapper.deleteSongsByAlbumAndArtist("Taylor Swift", "1989");

            songMapper.getSongsByArtist("Taylor Swift").forEach(System.out::println);


        };
    }
}
