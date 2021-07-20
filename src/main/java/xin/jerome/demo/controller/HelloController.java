package xin.jerome.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("")
    public String sayHello() {
        return "Hello Jerome, This is docker image !";
    }
}
