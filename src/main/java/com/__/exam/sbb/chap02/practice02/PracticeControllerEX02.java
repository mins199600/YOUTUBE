package com.__.exam.sbb.chap02.practice02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PracticeControllerEX02 {
    //게시글 추가
    //문제 : http://localhost:8080/addArticle?title=제목&body=내용 >> 1번글이 등록되었습니다.
    //문제 : http://localhost:8080/addArticle?title=제목&body=내용 >> 2번글이 등록되었습니다.
    @GetMapping("/addArticle")
    @ResponseBody
    public String showArticle(@RequestParam("title")String title, @RequestParam("body")String body){
       if("제목".equals(title)&&"내용".equals(body)){
           return "<h1>1번글이 등록되었습니다</h1>";
       }
       return "<h1>" + title + "</h1><p>" + body + "</p>";
    }
}
