package com.bookshop.bookShop.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaludoController {
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hola Mundo!";
    }

    @GetMapping("/name-hello-world/{name}/{age}")
    public String helloWorldName(@PathVariable String name, @PathVariable int age){
        return "Hello world! " + name + "Your age is: " + age;
    }
}
