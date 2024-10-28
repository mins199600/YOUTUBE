package com.__.exam.sbb.chap02.practice02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PracticeControllerEX03 {
    //게시물 리스팅
    //문제 : http://localhost:8080/article/list >> 전체 게시물 출력
    @GetMapping("/article/list")
    @ResponseBody
    public List<String> showList(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        return list;
    }
}
