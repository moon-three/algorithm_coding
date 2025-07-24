import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if('0' <= ch && ch <= '9') {
                list.add(ch - '0');
            }
        }
        
        Collections.sort(list);
        
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}