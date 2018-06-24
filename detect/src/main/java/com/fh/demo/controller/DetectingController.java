package com.fh.demo.controller;

import com.fh.demo.DetectInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * User: guangtou
 * Date: 2018/6/24 16:05
 */
@RestController
public class DetectingController {

    @RequestMapping(value = "/detecting/put_data", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody
    HashMap<String, Object> test(@RequestBody DetectInfo detectInfo) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("errorMessage", "");

        System.out.println("detectInfo = " + detectInfo);

        return map;

    }
}
