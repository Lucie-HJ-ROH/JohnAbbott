package com.example.hello.controller;

import com.example.hello.dto.UserRequeet;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/get")
public class GetApiController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }


    @RequestMapping(path = "/hi", method = RequestMethod.GET)  //fet http://localhost:8080/api/get/hi
    public String hi() {
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{}
    @GetMapping(value = "/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable: " + pathName);
        return pathName;
    }

    // http://localhost:8080/api/get/query-param?user=steve&email=steve@gamil.com&age=30
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam) {
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
           sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });
        return sb.toString();
    }


    @GetMapping("/query-param02")
    public String queryParam02(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam int age){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;

    }

    @GetMapping("/query-param03")
    public String queryParam03(UserRequeet userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();

    }



}
