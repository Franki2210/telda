package com.example.demo;

import com.example.demo.mapper.RegionMapper;
import com.example.demo.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegionListController {

    @Autowired
    RegionMapper regionMapper;

    /*Добавление региона в бд. Принимает json добавляемого объекта*/
    @PostMapping
    public Integer addRegion(@RequestBody Region region) {
        return regionMapper.add(region);
    }

    /*Получение региона по id*/
    @GetMapping
    public Region getById(@RequestParam String id) {
        return regionMapper.getById(id);
    }

    /*Изменение региона по его id*/
    @PatchMapping
    public void updateById(@RequestBody Region region) {
        regionMapper.update(region);
    }

    /*Удаление по id*/
    @DeleteMapping
    public void deleteById(@RequestParam String id) {
        regionMapper.deleteById(id);
    }

}
