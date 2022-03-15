package com.example.demo.mapper;

import com.example.demo.model.Region;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames={"regions"})
public interface RegionMapper {

    @Cacheable(key = "#id")
    @Select("SELECT * FROM region WHERE id = #{id}")
    Region getById(String id);

    @Cacheable(key = "#region.id")
    @Insert("INSERT INTO region(id, name, shortname) VALUES (#{id}, #{name}, #{shortName})")
    Integer add(Region region);

    @CacheEvict(key = "#region.id")
    @Update("UPDATE region SET name = #{name}, shortname = #{shortName} WHERE id = #{id}")
    void update(Region region);

    @CacheEvict(key = "#id")
    @Delete("DELETE FROM region WHERE id = #{id}")
    void deleteById(String id);
}
