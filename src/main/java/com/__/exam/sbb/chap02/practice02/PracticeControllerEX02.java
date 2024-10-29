package com.__.exam.sbb.chap02.practice02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PracticeControllerEX02 {
    //게시글 추가
    //문제 : http://localhost:8080/addArticle?title=제목&body=내용 >> 1번글이 등록되었습니다.
    //문제 : http://localhost:8080/addArticle?title=제목&body=내용 >> 2번글이 등록되었습니다.
    private List<Article> articles;
    public PracticeControllerEX02() {
        articles = new ArrayList<>();
    }
    @GetMapping("/addArticle1")
    @ResponseBody
    public String showArticle(@RequestParam("title")String title, @RequestParam("body")String body){
       if("제목".equals(title)&&"내용".equals(body)){
           return "<h1>1번글이 등록되었습니다</h1>";
       }
       return "<h1>" + title + "</h1><p>" + body + "</p>";
    }
    @GetMapping("/addArticle2")
    @ResponseBody
    public String addArticle(String title, String body){
        Article article = new Article(title, body);
        System.out.println(article);
        articles.add(article);
        return "%d번 게시물이 추가되었습니다".formatted(article.getId());
    }
}
//정답
@AllArgsConstructor
@Getter
@ToString
class Article{
    private static int lastId;
    private final int id;
    private final String title;
    private final String body;

    static {
        lastId = 0;
    }

    public Article(String title, String body){
        this(++lastId, title, body);    //메소드 오버로딩
    }
}