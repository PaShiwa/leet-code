package LeetCode.src.main.java.array;

import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strings){
        Map<String, List<String>> map = new HashMap<>();
        for(String string: strings){
            int[] frequency = new int[26];
            for(char c: string.toCharArray()){
               frequency[c-'a']++;
            }
            String key = Arrays.toString(frequency);
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(string);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] arrString = {"act","pots","tops","cat","stop","hat" };
        System.out.println(new GroupAnagrams().groupAnagrams(arrString));
    }
}
