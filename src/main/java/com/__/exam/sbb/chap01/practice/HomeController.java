package com.__.exam.sbb.chap01.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {
/*      문제 : http://localhost:8080/gugudan4?dan=4&limit=9 입력시 화면에 4단 보이게 하시오
        답안
            4 * 1 = 4
            4 * 2 = 8
            4 * 3 = 12
            4 * 4 = 16
            4 * 5 = 20
            4 * 6 = 24
            4 * 7 = 28
            4 * 8 = 32
            4 * 9 = 36*/
    @GetMapping("/gugudan4")
    @ResponseBody
    public String guguDan(Integer dan, Integer limit){
        if(dan == null){
            dan = 4;
        }
        if(limit == null){
            limit = 9;
        }
        Integer finalDan = dan;
        return IntStream.rangeClosed(1,limit)
                .mapToObj(i -> "%d * %d = %d".formatted(finalDan, i, finalDan * i))
                .collect (Collectors.joining("<br>"));
    }

    //문제 : http://localhost:8080/mbti?name=이수민 검색하면 화면에 ESTJ 나오게 하기
    @GetMapping("/mbti/{name}")
    @ResponseBody
   /* public String mbti(@RequestParam(value = "name", required = true)String name){
        switch (name){
            case "이수민" :
                return "ESTJ";
            case "김문수" :
                return "ESTP";
            case "이뽕이" :
                return "INFJ";
            case "이초코" :
                return "ESFP";
            default:
                return "insert name please";
        }*/
    public String showMbti(@PathVariable String name) {
        return switch (name) {
            case "홍길동" -> "INFP";
            case "홍길순" -> "ENFP";
            case "임꺽정" -> "ESFJ";
            case "이수민" -> "INFJ";
            default -> "모름";
        };
    }
}


