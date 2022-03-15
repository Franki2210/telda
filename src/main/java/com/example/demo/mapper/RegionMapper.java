package com.example.demo.mapper;

import com.example.demo.model.Region;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionMapper {

    @Select("SELECT * FROM region WHERE id = #{id}")
    Region getById(String id);

    @Select("SELECT * FROM region WHERE name = #{name}")
    Region getByName(String name);

    @Select("SELECT * FROM region WHERE shortname = #{shortname}")
    Region getByShortname(String shortname);

    @Insert("INSERT INTO region(id, name, shortname) VALUES (#{id}, #{name}, #{shortName})")
    Integer add(Region region);

    @Update("UPDATE region SET name = #{name}, shortname = #{shortName} WHERE id = #{id}")
    void update(Region region);

    @Delete("DELETE FROM region WHERE id = #{id}")
    void deleteById(String id);
}
