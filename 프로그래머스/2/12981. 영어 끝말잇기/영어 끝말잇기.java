import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] result = new int[2];

        Set<String> set = new HashSet<>();
        
        int cnt = 1;
        int num = 0;
        for(int i = 0; i < words.length; i++) {
            num++;
            
            if(set.contains(words[i])) {
                result[0] = num;
                result[1] = cnt;
                break;
            }
            
            if(i > 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                result[0] = num;
                result[1] = cnt;
                break;
            }
            
            set.add(words[i]);
            
            if(num == n) {
                cnt++;
                num = 0;
            }
        }
        
        return result;
    }
}