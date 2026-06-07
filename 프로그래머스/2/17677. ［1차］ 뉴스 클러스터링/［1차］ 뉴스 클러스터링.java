import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int union = 0;
        
        for(int i = 0; i < str1.length() - 1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);
            
            if((('a' <= ch1 && ch1 <= 'z') || ('A' <= ch1 && ch1 <= 'Z')) &&
              (('a' <= ch2 && ch2 <= 'z') || ('A' <= ch2 && ch2 <= 'Z'))) {
                String s = "" + ch1 + ch2;
                s = s.toLowerCase();
                map1.put(s, map1.getOrDefault(s, 0) + 1);
                union++;
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);
            
            if((('a' <= ch1 && ch1 <= 'z') || ('A' <= ch1 && ch1 <= 'Z')) &&
              (('a' <= ch2 && ch2 <= 'z') || ('A' <= ch2 && ch2 <= 'Z'))) {
                String s = "" + ch1 + ch2;
                s = s.toLowerCase();
                map2.put(s, map2.getOrDefault(s, 0) + 1);
                union++;
            }
        }

        int intersection = 0;
        for(String s : map1.keySet()) {
            if(!map2.containsKey(s)) continue;
            intersection += Math.min(map1.get(s), map2.get(s));
        }
        
        union -= intersection;
        
        if(union == 0) return 65536;
            
        return intersection * 65536 / union;
    }
}