package com.example.toyproject.view.Utils.SetLanguageList;

import java.util.ArrayList;
import java.util.List;

public class ListLanguage {

    public static List setList(){
        List<String> list = new ArrayList<>();

        list.add("한국어");
        list.add("영어");
        list.add("중국어(간체)");
        list.add("중국어(번체)");
        list.add("스페인어");
        list.add("프랑스어");
        list.add("베트남어");
        list.add("태국어");
        list.add("인도네시아어");

        return list;
    }
}
