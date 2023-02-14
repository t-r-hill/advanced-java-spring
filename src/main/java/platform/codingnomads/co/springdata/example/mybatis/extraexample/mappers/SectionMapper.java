package platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Section;

import java.util.List;

@Mapper
public interface SectionMapper {

    @Insert("INSERT INTO mybatis.sections (name) VALUES (#{name});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertNewSection(Section section);

    @Select("SELECT * FROM mybatis.sections WHERE id = #{param1};")
    @Results(
            @Result(
                    property = "chapters",
                    column = "id",
                    javaType = List.class,
                    many = @Many(
                            select = "com.bensiegler.mappers.ChapterMapper.getChaptersBySectionId",
                            fetchType = FetchType.LAZY
                    )
            )
    )
    Section getSectionById(Long sectionId);

    @Delete("DELETE FROM mybatis.sections WHERE id = #{id};")
    int deleteSectionById(Long id);
}
