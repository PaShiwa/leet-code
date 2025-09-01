package LeetCode.src.main.java.string;

import com.sun.source.tree.IfTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s1, String s2){
       if (s1.length() != s2.length())
           return false;

       Map<Character, Integer> map1 = new HashMap<>();
       Map<Character, Integer> map2 = new HashMap<>();

       for(char c : s1.toCharArray()){
          map1.put(c, map1.getOrDefault(c,0)+1);
       }

        for(char c : s2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        return map1.equals(map2);
    }
    public static void main(String[] args) {
        String s1 = "tea";
        String s2 = "ate";
        System.out.println(s1 + " and " + s2 + " are anagrams? -> "+ new ValidAnagram().isAnagram(s1, s2));

        String s3 = "jar";
        String s4 = "jam";
        System.out.println(s3 + " and " + s4 + " are anagrams? -> "+new ValidAnagram().isAnagram(s3, s4));
    }
}
