package com.__.exam.sbb.chap01.getPostmapping.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private int increaseNo;

    public MainController() {
        increaseNo = -1;
    }

    @RequestMapping("/sbb")
    @ResponseBody
    public String index(){
        return "안녕하세요.";
    }
    @GetMapping("/page1")
    @ResponseBody
    public String showGet(){
        return """
               <form method="POST" action="/page2"/>
                <input type = "number" name="age" placeholder="나이입력" />
                <input type = "submit" value="page2 POST 방식으로 이동" />
               </form>
                """;
    }


    @PostMapping("/page2")
    @ResponseBody
    public String showPage2Post(@RequestParam(defaultValue = "0") int age){
        return """
                <h1>입력된 나이 : %d</h1>
                <h1>안녕하세요. POST 방식으로 오신걸 환영합니다.</h1>
               """.formatted(age);
    }

    @GetMapping("/page2")
    @ResponseBody
    public String showPost(@RequestParam(defaultValue = "0") int age){
        return """
               <h1>안녕하세요. GET 방식으로 오신걸 환영합니다.</h1>
               <h1>입력된 나이 : %d</h1>
               <form method="POST" action="/page2"/>
                <input type = "submit" value="page2 POST 방식으로 이동" />
               </form>
               """.formatted(age);
    }

    @GetMapping("/plus")
    @ResponseBody
    public String plus(int a, int b){
        return """
                <h1>안녕하세요 더하기 계산기 입니다</h1>
                <h1>입력된 숫자 a : %d</h1>
                <h1>입력된 숫자 b : %d</h1>
                <h1>결과 : %d</h1>
                """.formatted(a, b, a + b);
    }
    @GetMapping("/minus")
    @ResponseBody
    public String sub(int a, int b){
        return """
                <h1>안녕하세요 빼기 계산기 입니다</h1>
                <h1>입력된 숫자 a : %d</h1>
                <h1>입력된 숫자 b : %d</h1>
                <h1>결과 : %d</h1>
                """.formatted(a, b, a - b);
    }
    @GetMapping("/increase")
    @ResponseBody
    public String increase(HttpSession session){
        Integer num = (Integer) session.getAttribute("num");
        if(num == null){
            num = 0;
        }
        session.setAttribute("num", num + 1);
        return """
                <h1>%d</h1>
                """.formatted(num);
    }
    @GetMapping("/increaseNo")
    @ResponseBody
    public int showIncrease(){
        increaseNo++;
        return increaseNo;
    }
    @GetMapping("/plus2")
    @ResponseBody
    public int showPlus2(HttpServletRequest req, HttpServletResponse resp){
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        return a + b;
    }
}
