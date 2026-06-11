import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] orders = new int[26];
        
        int order = 1;
        for(int i = 0; i < skill.length(); i++) {
            orders[skill.charAt(i) - 'A'] = order++;
        }
        
        System.out.println(Arrays.toString(orders));
        
        
        for(int i = 0; i < skill_trees.length; i++) {
            String st = skill_trees[i];
            boolean isPossible = true;
            int value = 0;
            for(int j = 0; j < st.length(); j++) {
                int cur = orders[st.charAt(j) - 'A'];
                if(cur == 0)  continue;
                if(cur == value + 1) {
                    value++;
                } else {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) answer++;
        }
        return answer;
    }
}