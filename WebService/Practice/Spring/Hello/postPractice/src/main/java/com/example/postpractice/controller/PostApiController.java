package com.example.postpractice.controller;


import com.example.postpractice.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto requestData) {
        System.out.println(requestData);
    }

}
