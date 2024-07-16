package ru.gb.timesheet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//@Controller
//Все аннотации, что стоят над контроллером, идут на все методы класса.
//Возвращать сразу полученную строку.
//@RestController объединяет в себе @Controller и @ResponseBody.
//@ResponseBody.
@RestController
public class HelloController {

    // GET http://localhost:8080/hello?username=alex&city=Moscow
    // @GetMapping может заменить строку method = RequestMethod.GET
    @GetMapping("/hello")
    public String helloPage(@RequestParam String username){
        return "<h1>Hello " + username + "!<h1>";
        }

    @GetMapping("/hello/{username}")
    public String helloPagePathVariable(@PathVariable("username") String username) {
        return "<h1>Hello " + username + "!<h1>";
    }

//    @GetMapping("/home")
//    public String homePage(){
//        return "Home page";
//    }
}
