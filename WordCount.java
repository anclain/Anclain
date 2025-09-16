package EntryTest;

import java.util.*;

public class WordCount {

    public static void main(String[] args) {
        String line = "In the deep velvet canvas of the cosmos, where nebulae bloom like cosmic flowers and silent planets drift in their ancient orbits, a breathtaking tapestry of light and shadow unfolds—a reminder of our place in an endless, awe-inspiring story.";
        List<String> apply = renew(line);
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : apply) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String [] words = map.keySet().toArray(new String[0]);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(int i = 0; i < 3; i++){
            System.out.print(list.get(i).getKey() + " ");
            System.out.println(list.get(i).getValue());
        }
    }

    public static List<String> renew(String line){
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
