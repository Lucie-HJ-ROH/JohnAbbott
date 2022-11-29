package com.example.hellowebservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWs {
    @WebMethod
    public String Hello(){
        return "Hello, world!";
    }
}

