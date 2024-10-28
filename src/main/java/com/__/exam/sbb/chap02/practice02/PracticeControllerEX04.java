package com.__.exam.sbb.chap02.practice02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class PracticeControllerEX04 {
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
}
