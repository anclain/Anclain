package EntryTest;

import java.util.*;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<String> apply = renew(line);
        HashMap<String, Integer> map = new HashMap<>();                   //将词组数据放入HashMap中
        for (String word : apply) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String [] words = map.keySet().toArray(new String[0]);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));                //通过HashMap中的value值进行倒叙排列

        for(int i = 0; i < 3; i++){
            System.out.print(list.get(i).getKey() + " ");
            System.out.println(list.get(i).getValue());
        }
    }

    public static List<String> renew(String line){               //定义题词工具，去除其他符号
        String clean = line.replaceAll("[^a-zA-Z0-9 ]", " ").trim();             
        String[] words = clean.split(" +");
        List<String> list = new ArrayList<>();
        for (String word : words) {
            String temp = word.toLowerCase();
            list.add(temp);
        }
        return list;
    }
}

