package com.dktechno.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class FirstController {

    //@GetMapping("hello")
    public String sayHello(){
        return "Hello from my first controller";
    }

    @PostMapping("post")
    public String post(@RequestBody String message) {
        return "request accepted and message is : " + message;
    }

    @PostMapping("post-order")
    public String post(@RequestBody Order order) {
        return "Request accepted and order is : " + order.toString();
    }


    @PostMapping("post-order-record")
    public String postOrderRecord(@RequestBody OrderRecord order) {
        return "Request accepted and order is : " + order.toString();
    }

    @GetMapping("hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String username){
        return "my value = "+ username;
    }

    // http://localhost:8080/hello2?param_name=paramvalu&param_value2=value2
    @GetMapping("hello")
    public String paramVar(@RequestParam("user-name") String username,
                           @RequestParam("user-lastname") String userLastname){
        return "my value = "+ username + "  " + userLastname;
    }

}
