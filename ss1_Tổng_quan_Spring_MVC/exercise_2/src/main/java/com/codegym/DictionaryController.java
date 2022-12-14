package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    @GetMapping("")
    public String SimpleDictionary(Model model,String english){
        String[] arr = {"hello","thank","black","red","apple","bye"};
        String[] arr1 = {"xin chào","cảm ơn","màu đen","màu đỏ","quả táo","tạm biệt"};
        String keyWord = english;
        String means = null;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i].equals(keyWord)){
                means = "nghĩa của từ đó là: "+ arr1[i];
                break;
            }else {
                means = "Không tìm thấy ["+ keyWord +"] trong từ điển đơn giản";
            }
        }
        model.addAttribute("mess",means);
        return "/result";
    }
}
