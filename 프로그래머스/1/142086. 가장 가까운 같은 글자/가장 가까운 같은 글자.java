import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] chs = s.toCharArray();
        
        for(int i = 0; i < chs.length; i++) {
            if(!hm.containsKey(chs[i])) {
                answer[i] = -1;
            } else {
                answer[i] = i - hm.get(chs[i]);
            }
            hm.put(chs[i], i);
        }
        
        return answer;
    }
}