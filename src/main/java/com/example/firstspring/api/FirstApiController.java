package com.example.firstspring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestAPI용 컨트롤러 -> Json을 반환한다. [*데이터를 반환한다*]
public class FirstApiController {
    @GetMapping("/api/hello")
    public String hello(){
        return "Hello World!";
    }
}
