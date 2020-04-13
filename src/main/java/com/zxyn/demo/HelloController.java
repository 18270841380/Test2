package com.zxyn.demo;


import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class HelloController {



    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String hello(@RequestParam(value="id",required = false,defaultValue = "1") Integer id) {
        return "id:"+id;
    }

    @GetMapping(path = "req")
    public String requestParam(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        return JSONObject.fromObject(parameterMap).toString();
    }

    @GetMapping(path = "req2")
    public String requestParam2() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        return JSONObject.fromObject(parameterMap).toString();
    }

    @GetMapping(path="arg")
    public String argParam(String name,Integer age) {
        return "name;"+name+",age:"+age;
    }

    @GetMapping(path = "ano")
    public String anoParam(@RequestParam(name="name") String username,@RequestParam(name="age",required = false) Integer age) {
        return "username:"+username+",age:"+age;
    }


}
