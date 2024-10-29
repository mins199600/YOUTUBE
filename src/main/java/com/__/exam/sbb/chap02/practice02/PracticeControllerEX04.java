package com.__.exam.sbb.chap02.practice02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PracticeControllerEX04 {
    private List<Article> articles;
    //게시물 상세보기
    //문제 : http://localhost:8080/article/detail/1 >> 1번 게시물 가져오기, 입력받은 숫자에 따른 데이터 출력
    //{
    //  "id" : 1,
    //  "title" : "제목",
    //  "body" : 내용
    // }
    @GetMapping("/article/detail/{id}")
    @ResponseBody
    public Map<String, Object> detail(@PathVariable("id") int id) {
        if (id == 1) {
            Map<String, Object> detailMap = new LinkedHashMap<>();
            detailMap.put("id", 1);
            detailMap.put("title", "제목");
            detailMap.put("body", "내용");
            return detailMap;
        } else {
            return null;
        }
    }
    @GetMapping("/article2/detail/{id}")
    @ResponseBody
    public Article getArticle(@PathVariable int id){
        Article article = articles.stream()
                        .filter(a->a.getId() == id)     //게시물 id와 내가 입력한 id가 일치하는지 확인
                        .findFirst().orElse(null);  //입력한 번호의 게시물이 없으면 null 반환

        return article;
    }
}
