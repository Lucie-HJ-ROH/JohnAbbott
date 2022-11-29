package com.example.hellowebservice.ioc;

import java.net.URLEncoder;

public class Main {
    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page";

        Encoder encoder = new Encoder();
        String result = encoder.encode(url);

        URLEncoder urlEncoder = new UrlEncoder();
        String rulReset = urlEncoder.encode(url);
        System.out.println(result);
    }
}
