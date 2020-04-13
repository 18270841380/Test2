package com.zxyn.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class Demo2 {

    public enum TYPE {
            A,B,C
    }

//    @GetMapping(path="arg2")
//    public String argParam2(String[] names,int size) {
//        return "name:"+(names != null ? Arrays.asList(names) : "null")+"size:"+size;
//    }

    @GetMapping(path="enum")
    public String enumParam(TYPE type) {
        return type.name();
    }

    @GetMapping(path="enum2")
    public String enumParam2(@RequestParam TYPE type) {
        return type.name();
    }

    @GetMapping(path = "mapper")
    public String mapperParam(@RequestParam Map<String,Object> params) {
        return params.toString();
    }

    @GetMapping(path = "mapper2")
    public String mapperParam2(Map<String,Object> params) {
        return params.toString();
    }

    @GetMapping(path = "ano1")
    public String anoParam1(@RequestParam(name = "names") List<String> names) {
        return "names:" + names;
    }

    @GetMapping(path = "arg3")
    public String anoParam2(List<String> names) {
        return "names:"+names;
    }


}
