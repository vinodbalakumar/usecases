package com.sg.dayamed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CodeChefV2 {

  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in); 
    System.out.print("Enter NO of ingredients for day : ");
    int noIng = sc.nextInt();
    int sixtyPerc = (int) Math.ceil(noIng * (60/100.0f));
    int n = 0;
    Map<String, Integer> val = new HashMap<>();
    String[] ingredients =
        {"FATOil", "FIBERSpinach", "CARBRice", "FATCheese", "FIBERBeans", "FATEgg", "FIBERBroccoIi",
            "CARBPotato", "CARBCorn", "FATOlive", "FIBERCarrot", "CARBBeetroot"};

    List<String> refrigerator = new ArrayList<>();
    for (String arr : ingredients) {
      refrigerator.add(arr);
      val.put(arr, n = n + 1);
    }
    Map<String, Object> storedI = new HashMap<>();
    storedI.put("FAT", 0);
    storedI.put("FIBER", 0);
    storedI.put("CARB", 0);
    storedI.put("TOTAL", 0);
    storedI.put("CHEFDAY", "");

    for (String ingredient : ingredients) {
      System.out.println("Before for loop current :" + refrigerator);
      System.out.println("ingredient : " + ingredient);
      if (ingredient.contains("FAT")) {
        storedI.put("FAT", (int) storedI.get("FAT") + 1);
      } else if (ingredient.contains("FIBER")) {
        storedI.put("FIBER", (int) storedI.get("FIBER") + 1);
      } else if (ingredient.contains("CARB")) {
        storedI.put("CARB", (int) storedI.get("CARB") + 1);
      }
      storedI.put("TOTAL", (int) storedI.get("TOTAL") + 1);
      System.out.println("total :" + storedI.get("TOTAL"));
      if ((int) storedI.get("TOTAL") >= noIng) { // no of ing
        if ((int) storedI.get("FAT") >= sixtyPerc)
          cook_food("FAT", storedI, refrigerator, val,sixtyPerc);
        else if ((int) storedI.get("FIBER") >= sixtyPerc)
          cook_food("FIBER", storedI, refrigerator, val,sixtyPerc);
        else if ((int) storedI.get("CARB") >= sixtyPerc)
          cook_food("CARB", storedI, refrigerator, val,sixtyPerc);
        else
          storedI.put("CHEFDAY", storedI.get("CHEFDAY") + "-");
      } else {
        storedI.put("CHEFDAY", storedI.get("CHEFDAY") + "-");
      }
    }
    System.out.println("Total :" + storedI.get("TOTAL") + ", CHEFDAY : " + storedI.get("CHEFDAY"));
    System.out.println("" + refrigerator);
  }

  private static void cook_food(String ingredientType, Map<String, Object> storedI,
      List<String> refrigerator, Map<String, Integer> val,int sixtyPerc) {
    int flag = sixtyPerc;

    Map<Integer, String> tempVal = new TreeMap<>();
    String removalTemp = "";
    for (Iterator<String> itr = refrigerator.iterator(); itr.hasNext();) {
      String ingre = itr.next();
      if (flag > 0 && ingre.contains(ingredientType)) {
        tempVal.put(val.get(ingre), ingre);
        itr.remove();
        flag -= 1;
        storedI.put(ingredientType, (int) storedI.get(ingredientType) - 1);
      }
      if (flag == 0) {
        break;
      }
    }
    if (flag == 0) {
      String tmpI = refrigerator.remove(0);
      tempVal.put(val.get(tmpI), tmpI);
      if (tmpI.contains("FAT")) {
        storedI.put("FAT", (int) storedI.get("FAT") - 1);
      } else if (tmpI.contains("FIBER")) {
        storedI.put("FIBER", (int) storedI.get("FIBER") - 1);
      } else if (tmpI.contains("CARB")) {
        storedI.put("CARB", (int) storedI.get("CARB") - 1);
      }
      storedI.put("TOTAL", (int) storedI.get("TOTAL") - 4);

    }
    for (Integer key : tempVal.keySet()) {
      removalTemp =
          removalTemp.length() == 0 ? tempVal.get(key) : removalTemp + ":" + tempVal.get(key);
    }
    storedI.put("CHEFDAY", storedI.get("CHEFDAY") + removalTemp);

  }

}

