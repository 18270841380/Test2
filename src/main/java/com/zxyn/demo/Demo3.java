package com.zxyn.demo;


import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * post请求的测试
 */
@Controller
public class Demo3 {

    /**
     * post请求的body为string时,直接封装请求体里面的数据到参数中
     */
    @RequestMapping(value="/testBody",method= RequestMethod.POST)
    public @ResponseBody String getString(@RequestBody String body) {
        return body;
    }

    /**
     * 取json参数
     */
    @RequestMapping(value="/testJson",method=RequestMethod.POST)
    public @ResponseBody
    Map getJson(@RequestBody Map mmap) {
        return mmap;
    }

    /**
     *取文本参数
     */
    @RequestMapping(value="/testText",method=RequestMethod.POST)
    public @ResponseBody Object getText(HttpServletRequest request) {
        String body = null;
        try {
            BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(request.getInputStream()));
            body = IOUtils.toString(bufferedReader);
        } catch (IOException e) {
            System.out.println("读取数据失败！");
        }
        return body;
    }

    /**
     * 取自定义的参数
     */
    @RequestMapping(value="/testObject",method = RequestMethod.POST)
    public @ResponseBody Animal getObject(@RequestBody Animal animal) {
        return animal;
    }

}
