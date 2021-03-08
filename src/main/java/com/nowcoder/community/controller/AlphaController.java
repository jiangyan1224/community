package com.nowcoder.community.controller;

import com.nowcoder.community.entity.Page;
import com.nowcoder.community.service.AlphaService;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello spring boot";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    @ResponseBody
    public void getHTTP(HttpServletRequest request, HttpServletResponse response){
        //请求的第一行
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURL());
        //请求头
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }
        //请求体
        System.out.println(request.getParameter("code"));

        response.setContentType("text/html;charset=utf-8");
        try (
                PrintWriter writer = response.getWriter();
                ) {
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // /students?page=1&limit=10
    //GET 一般用于浏览器向服务器请求数据
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(value = "page", required = false, defaultValue = "1")int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10")int limit){
        System.out.println(page + "," + limit);
        return "getStudents success";
    }

    // /student/123
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getAStudent(@PathVariable int id){
        System.out.println(id);
        return "getAStudent success";
    }

    //POST 一般用于浏览器向服务器提交数据（GET也可以提交数据，但是参数都是在请求路径上，而请求路径url长度有限）
    @RequestMapping(path = "/addStu", method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(String name, int age){
        System.out.println(name + "," + age);
        return "addStu success";
    }

    //实验，路径后面如果携带了page内部属性同名的参数，page是可以获取到对应值的
    //如 /alpha/student1?page=45&limit=2
    @RequestMapping(path = "/student1", method = RequestMethod.GET)
    @ResponseBody
    public String getPage(Page page){
        System.out.println(page.getCurrent());
        return "getPage success";
    }
}
