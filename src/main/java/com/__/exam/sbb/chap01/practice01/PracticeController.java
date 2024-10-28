package com.__.exam.sbb.chap01.practice01;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PracticeController {
    //문제 : http://localhost8080/saveSessionAge?age=10 접속하면 화면에 10이 출력되는것
    @GetMapping("/saveSessionAge")
    @ResponseBody
    public String saveSessionAge(@RequestParam int age, HttpSession session) {
        session.setAttribute("age", age);
        return String.format("<h1>%d</h1>",age);
    }
    //문제 : http://localhost8080/saveSessionAge 접속하면 화면에 10이 출력되는것
    @GetMapping("/saveSessionAge2")
    @ResponseBody
    public String saveSessionAge2(@RequestParam(defaultValue = "10")int num){
        return String.format("<h1>%d</h1>",num);
    }
    //문제 : http://localhost8080/saveSessionAge/10 접속하면 화면에 10이 출력되는것
    @GetMapping("/saveSessionAge3/{age}")
    @ResponseBody
    public String saveSessionAge(@PathVariable Integer age) {
        return age.toString();
    }
}
