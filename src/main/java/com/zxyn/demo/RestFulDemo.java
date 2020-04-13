package com.zxyn.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestFulDemo {

    /**
     * 查询
     */
    @RequestMapping(value = "/xx/{name}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String query(@PathVariable("name")String username) {
        return "username:" + username;
    }

    /**
     * 增加
     */
    @RequestMapping(value = "/xx",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String add(@RequestBody Animal animal) {
        return "名称："+animal.getName()+",年龄："+animal.getAge()+",性别："+animal.getSex();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/xx",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public String update(@RequestBody Animal animal) {
        return "你修改了"+animal.getName();
    }

    /**
     * 删除
     */
    @RequestMapping(value="/xx/{name}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public String delete(@PathVariable("name") String name) {
        return "你删除了"+name;
    }
}
