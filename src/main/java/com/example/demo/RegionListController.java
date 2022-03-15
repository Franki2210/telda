package com.example.demo;

import com.example.demo.mapper.RegionMapper;
import com.example.demo.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@RestController
public class RegionListController {

    @Autowired
    RegionMapper regionMapper;

    Map<String, Function<String, Region>> regionFieldToGetMap;

    public RegionListController() {
        regionFieldToGetMap = new HashMap<>();

        regionFieldToGetMap.put("id", (id) -> regionMapper.getById(id));
        regionFieldToGetMap.put("name", (name) -> regionMapper.getByName(name));
        regionFieldToGetMap.put("shortname", (shortname) -> regionMapper.getByShortname(shortname));
    }

    /*Добавление региона в бд*/
    @PostMapping
    public Integer addRegion(@RequestBody Region region) {
        return regionMapper.add(region);
    }

    /*Получение региона по полю (id, name, shortname)*/
    @GetMapping("/{field}")
    public Region getById(@PathVariable("field") String field, @RequestParam String value) {
        return regionFieldToGetMap.get(field).apply(value);
    }

    /*Изменение региона по его id. Берём id из тела запроса и обновляем сущность на новые значения*/
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
