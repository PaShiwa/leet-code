package LeetCode.src.main.java.string;
// Valid for string having only the letters. NO special characters, numbers, symbol!
public class IsAnagram {
    public boolean isAnagram(String s1, String s2){
    if (s1.length() != s2.length())
            return false;

   int[] counts = new int[26];

   for(int i =0; i<s1.length();i++){
       counts[s1.charAt(i)-'a']++;
       counts[s2.charAt(i)-'a']--;
   }

   for(int count: counts){
       if (count !=0){
           return false;
       }
   }
   return true;
}
    public static void main(String[] args) {
        String s1 = "tea";
        String s2 = "ate";
        System.out.println(s1 + " and " + s2 + " are anagrams? -> "+ new IsAnagram().isAnagram(s1, s2));

        String s3 = "jar";
        String s4 = "jam";
        System.out.println(s3 + " and " + s4 + " are anagrams? -> "+new IsAnagram().isAnagram(s3, s4));
    }
}
