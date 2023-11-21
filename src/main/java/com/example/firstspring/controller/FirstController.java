package com.example.firstspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/Hello") //URL 요청 연결 -> @GetMapping :: /Hello를 했을때 아래 mustache로 접근한다.
    //localhost:8080/Hello
    public String hello(Model model) { //templates변수를 활용하기 위해 파라미터로 Model 추가(import:: org.springframewor.ui.Model;
        model.addAttribute("username", "parkchwl"); // tamplates 변수를 활용하기 위해 model.Attribute
        // key : username, Value : parkchwl, greeting.mustache로 접근하여 Hello, parkchwl이 나올 수 있게 하였다.
        return "greetings"; // templates/greetings.mustache를 브라우저로 전송한다,.
    }
    @GetMapping("/Bye")
    public String bye(Model model){
        model.addAttribute("nickname", "parkchwl");
        return "goodbye";
    }
}
