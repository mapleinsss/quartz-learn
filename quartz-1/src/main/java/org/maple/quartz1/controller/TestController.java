package org.maple.quartz1.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Mapleins
 * @date 2019-08-12 9:19
 * @description TODO
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("get")
    public String testGet() {
        return "{\"opType\":0,\"content\":{\"id\":5,\"name\":\"Ella\",\"age\":18}};{\"opType\":0,\"content\":{\"id\":6,\"name\":\"Faker\",\"age\":25}}";
    }

    @PostMapping("post")
    public String testPost(@RequestBody Map<String, String> map) {
        if ("a".equalsIgnoreCase(map.get("info"))) {
            return "{\"opType\":0,\"content\":{\"id\":5,\"name\":\"Ella\",\"age\":18}};{\"opType\":0,\"content\":{\"id\":6,\"name\":\"Faker\",\"age\":25}}";
        }
        return null;
    }

}
