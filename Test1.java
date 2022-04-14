package com.sg.dayamed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test1 {


  static List<String> sortWordsByScore(List<String> words) {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String vowels = "aeiou";
    Map<Integer, String> temp = new TreeMap<>();
    List<String> response = new ArrayList<>();
    words.forEach(action -> {
      int x = 0;
      for (int i = 0; i < action.length(); i++) {
        if (vowels.contains("" + action.toLowerCase().charAt(i))) {
          x += (alphabet.indexOf(action.toLowerCase().charAt(i)) + 1) * 2;
        } else {
          x += (alphabet.indexOf(action.toLowerCase().charAt(i)) + 1);
        }

      }
      if (temp.containsKey(x)) {
        temp.put(x, temp.get(x) + "_" + action);
      } else {
        temp.put(x, action);
      }
    });

    for (Map.Entry<Integer, String> entry : temp.entrySet()) {
      String[] value = entry.getValue().toString().split("_");
      for (String str : value) {
        response.add(str);
      }
    }

    return response;
  }


  public static void main(String[] args) {
    List<String> li = Arrays.asList("this","this", "tat");
    System.out.println(sortWordsByScore(li));


  }

}
