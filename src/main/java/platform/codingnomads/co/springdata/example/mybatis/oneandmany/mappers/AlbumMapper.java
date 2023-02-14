package platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Album;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Mapper
public interface AlbumMapper {

    @Insert("INSERT INTO mybatis.albums " +
            "(name, year, artist_id) " +
            "VALUES (#{name}, #{year}, #{artist.id});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void addAlbum(Album album);

    @Select("SELECT * FROM mybatis.albums " +
            "WHERE id = #{param1};")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id",
                    property = "songs",
                    many = @Many(select = "platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.SongMapper.getSongsByAlbumId",
                                fetchType = FetchType.LAZY
                    )
            ),
            @Result(column = "artist_id",
                    property = "artist",
                    one = @One(select = "platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.ArtistMapper.getArtistById",
                                fetchType = FetchType.LAZY
                    )
            )

    })
    Album getAlbumByIdWithSongsAndArtist(long id);

    @Select("SELECT * FROM mybatis.albums WHERE id = #{param1};")
    Album getAlbumByIdWithoutSongsOrArtist(long id);

    @Select("SELECT * FROM mybatis.albums WHERE artist_id = #{param1};")
    ArrayList<Album> getAlbumsByArtistId(long artistId);
}
