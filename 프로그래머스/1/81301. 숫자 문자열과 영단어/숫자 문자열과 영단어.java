import java.util.*;

class Solution {
    public int solution(String s) {
        
        Map<String, Integer> map = getMap();
        String result = "";
        String word = "";
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if('0' <= ch && ch <= '9') result += ch;
            else {
                word += ch;
                if(map.containsKey(word)) {
                    result += map.get(word);
                    word = "";
                }
            }
        }
        
        return Integer.parseInt(result);
    }
    
    public Map<String, Integer> getMap() {
        return Map.of(
        "one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight", 8,
        "nine", 9,
        "zero", 0);
    }
}