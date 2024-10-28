package com.__.exam.sbb.chap02.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class MainController2 {
    @GetMapping("/home/returnBoolean")
    @ResponseBody
    public boolean showReturnBoolean() {
        return false;
    }

    @GetMapping("/home/returnIntArr")
    @ResponseBody
    public int[] showReturnIntArr() {
        int[] arr = new int[]{10,20,30};
        return arr;
    }
    @GetMapping("/home/returnStringList")
    @ResponseBody
    public List<String> showReturnStringList() {
        List<String> list = new ArrayList<>() {{
            add("안녕");
            add("반가워");
            add("어서와");
        }};
/*        List<String> list2 = new ArrayList<>();
        list2.add("안녕");
        list2.add("반가워");
        list2.add("어서와");*/
        return list;
    }

    @GetMapping("/home/returnMap")
    @ResponseBody
    public Map<String, Object> showReturnMap(){
        Map<String, Object> map = new LinkedHashMap<>(){{
            put("id",1);
            put("age",5);
            put("name","이초코");
            put("related",new ArrayList<>(){{
                add(2);
                add(3);
                add(4);
            }});
        }};
        return map;
    }

    @GetMapping("/home/returnAnimal")
    @ResponseBody
    public AnimalV2 showReturnAnimal(){
        AnimalV2 animal = new AnimalV2(1,"초코뽕이",3,new ArrayList<>(){{
            add(2);
            add(3);
            add(4);
        }});
        animal.setName(animal.getName() + "V2");
        return animal;
    }

    @GetMapping("/home/returnAnimalMapList")
    @ResponseBody
    public List<Map<String, Object>> showReturnAnimalMapList(){
        Map<String, Object> animalMap1 = new LinkedHashMap<>(){{
            put("id",1);
            put("age",5);
            put("name","이초코");

            put("related",new ArrayList<>(){{
                add(2);
                add(3);
                add(4);
            }});
        }};

        Map<String, Object> animalMap2 = new LinkedHashMap<>(){{
            put("id",2);
            put("age",8);
            put("name","포비");

            put("related",new ArrayList<>(){{
                add(5);
                add(6);
                add(7);
            }});
        }};
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(animalMap1);
        list.add(animalMap2);
        return list;
    }
}

class Animal {
    private final int id;
    private final String name;
    private final int age;
    private final List<Integer> related;

    public Animal(int id, String name, int age, List<Integer> related) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.related = related;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", related=" + related +
                '}';
    }
}
    @AllArgsConstructor
    @Data
    class AnimalV2{
        private  int id;
        private  String name;
        private  int age;
        private  List<Integer> related;
}
