package com.sg.dayamed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CodeChefV1 {

  public static void main(String[] args) {
    int n = 12;
    String[] ingredients = {"FATOil", "FIBERSpinach", "CARBRice", "FATCheese", "FIBERBeans",
        "FATEgg", "FIBERBroccoIi", "CARBPotato", "CARBCorn", "FATOlive", "FIBERCarrot",
        "CARBBeetroot", "FATOil", "FIBERSpinach", "CARBRice", "FATCheese", "FIBERBeans", "FATEgg",
        "FIBERBroccoIi", "CARBPotato", "CARBCorn", "FATOlive", "FIBERCarrot", "CARBBeetroot",
        "FATOil", "FIBERSpinach", "CARBRice", "FATCheese", "FIBERBeans", "FATEgg", "FIBERBroccoIi",
        "CARBPotato", "CARBCorn", "FATOlive", "FIBERCarrot", "CARBBeetroot"};


    List<String> refrigerator = new ArrayList<>();
    for (String arr : ingredients) {
      refrigerator.add(arr);
    }
    Map<String, Object> storedI = new HashMap<>();
    storedI.put("FAT", 0);
    storedI.put("FIBER", 0);
    storedI.put("CARB", 0);
    storedI.put("TOTAL", 0);
    storedI.put("CHEFDAY", "");

    for (String ingredient : ingredients) {
      System.out.println("Before for loop current :" + refrigerator);
      System.out.println("ingredient ".format(ingredient));
      if (ingredient.contains("FAT")) {
        storedI.put("FAT", (int) storedI.get("FAT") + 1);
      } else if (ingredient.contains("FIBER")) {
        storedI.put("FIBER", (int) storedI.get("FIBER") + 1);
      } else if (ingredient.contains("CARB")) {
        storedI.put("CARB", (int) storedI.get("CARB") + 1);
      }
      storedI.put("TOTAL", (int) storedI.get("TOTAL") + 1);
      System.out.println("total :" + storedI.get("TOTAL"));
      if ((int) storedI.get("TOTAL") >= 3) {
        if ((int) storedI.get("FAT") >= 2) {

          int flag = 2;

          for (String ingre : refrigerator) {
            if (flag > 0 && ingre.contains("FAT")) {
              int index = refrigerator.indexOf(ingre);
              refrigerator.remove(index);
              flag -= 1;
              storedI.put("FAT", (int) storedI.get("FAT") - 1);
            }
          }
          if (flag == 0) {
            String tmpI = refrigerator.remove(0);
            if (tmpI.contains("FAT")) {
              storedI.put("FAT", (int) storedI.get("FAT") - 1);
            } else if (tmpI.contains("FIBER")) {
              storedI.put("FIBER", (int) storedI.get("FIBER") - 1);
            } else if (tmpI.contains("CARB")) {
              storedI.put("CARB", (int) storedI.get("CARB") - 1);
            }
            storedI.put("TOTAL", (int) storedI.get("TOTAL") - 3);
            storedI.put("CHEFDAY", storedI.get("CHEFDAY") + "1");
          }


        } else if ((int) storedI.get("FIBER") >= 2) {

          int flag = 2;

          for (String ingre : refrigerator) {
            if (flag > 0 && ingre.contains("FIBER")) {
              int index = refrigerator.indexOf(ingre);
              refrigerator.remove(index);
              flag -= 1;
              storedI.put("FIBER", (int) storedI.get("FIBER") - 1);
            }
          }
          if (flag == 0) {
            String tmpI = refrigerator.remove(0);
            if (tmpI.contains("FAT")) {
              storedI.put("FAT", (int) storedI.get("FAT") - 1);
            } else if (tmpI.contains("FIBER")) {
              storedI.put("FIBER", (int) storedI.get("FIBER") - 1);
            } else if (tmpI.contains("CARB")) {
              storedI.put("CARB", (int) storedI.get("CARB") - 1);
            }
            storedI.put("TOTAL", (int) storedI.get("TOTAL") - 3);
            storedI.put("CHEFDAY", storedI.get("CHEFDAY") + "1");
          } }

        else if ((int) storedI.get("CARB") >= 2)
        {

          int flag = 2;

          for (String ingre : refrigerator) {
            if (flag > 0 && ingre.contains("CARB")) {
              int index = refrigerator.indexOf(ingre);
              refrigerator.remove(index);
              flag -= 1;
              storedI.put("CARB", (int) storedI.get("CARB") - 1);
            }
          }
          if (flag == 0) {
            String tmpI = refrigerator.remove(0);
            if (tmpI.contains("FAT")) {
              storedI.put("FAT", (int) storedI.get("FAT") - 1);
            } else if (tmpI.contains("FIBER")) {
              storedI.put("FIBER", (int) storedI.get("FIBER") - 1);
            } else if (tmpI.contains("CARB")) {
              storedI.put("CARB", (int) storedI.get("CARB") - 1);
            }
            storedI.put("TOTAL", (int) storedI.get("TOTAL") - 3);
            storedI.put("CHEFDAY", storedI.get("CHEFDAY") + "1");
          }

        }
        else
          storedI.put("CHEFDAY", storedI.get("CHEFDAY") + "0");
      } else {
        storedI.put("CHEFDAY", storedI.get("CHEFDAY") + "0");
      }
    }
    System.out.println("Total :" + storedI.get("TOTAL") + ", CHEFDAY : " + storedI.get("CHEFDAY"));
    System.out.println("" + refrigerator);

  }

}

