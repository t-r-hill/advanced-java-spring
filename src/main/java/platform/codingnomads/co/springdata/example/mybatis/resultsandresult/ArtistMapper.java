package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface ArtistMapper {

    @Insert("INSERT INTO mybatis.artists " +
            "(name, age, genre) " +
            "VALUES (#{name}, #{age}, #{genre});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertArtist(Artist artist);

    @Select("SELECT * " +
            "FROM mybatis.artists " +
            "WHERE genre = #{genre};")
    @Results(id = "artistResultMap",
             value = {
                     @Result(column = "name", property = "name"),
                     @Result(column = "age", property = "age"),
                     @Result(column = "genre", property = "genre")
             })
    ArrayList<Artist> getByGenre(String genre);

    @Select("SELECT * " +
            "FROM mybatis.artists " +
            "WHERE age < #{age};")
    @ResultMap("artistResultMap")
    ArrayList<Artist> getByAgeLessThan(int age);

    @Delete("DELETE FROM mybatis.artists " +
            "WHERE id = #{id};")
    void deleteById(long id);
}
