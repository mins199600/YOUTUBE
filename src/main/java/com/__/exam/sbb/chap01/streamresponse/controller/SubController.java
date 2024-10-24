package com.__.exam.sbb.chap01.streamresponse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class SubController {
    @GetMapping("/gugudan")
    @ResponseBody
    public String showGugudan(Integer dan, Integer limit){
        if(dan == null){
            dan = 9;
        }
        if(limit == null){
            limit = 9;
        }
        Integer finalDan = dan;
        return IntStream.rangeClosed(1,limit)
                .mapToObj(i -> "%d * %d = %d".formatted(finalDan, i, finalDan * i))
                .collect (Collectors.joining("<br>"));
    }
}
