package com.zxyn.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Demo1 {

    @RequestMapping(value="/test",params = {"name","age"},method= RequestMethod.GET)
    public String getString(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String ip = request.getRemoteAddr();
        System.out.println("ip>>>>>>"+ip);
        System.out.println("====================");
        return name+","+age;
    }

    @RequestMapping(value="/test2")
    public @ResponseBody Animal getParam(Animal animal) {
        return animal;
    }

}
