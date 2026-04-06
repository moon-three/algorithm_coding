import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = new String[]{"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < babbling.length; i++) {
            for(int j = 0; j < words.length; j++) {
                babbling[i] = babbling[i].replaceAll(words[j], String.valueOf(j));
            }
            
            char prev = 10;
            boolean able = true;
            for(int j = 0; j < babbling[i].length(); j++) {
                char ch = babbling[i].charAt(j);
                if(('a' <= ch && ch <= 'z') || (prev == ch)) {
                    able = false;
                    break;   
                }
                prev = ch;
            }
            if(able) answer++; 
        }
        return answer;
    }
}