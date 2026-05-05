class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] chs = s.toCharArray();
        
        char value = chs[0];
        int same = 0;
        int other = 0;
        boolean isEqual = false;
        for(int i = 0; i < chs.length; i++) {
            if(isEqual) {
                answer++;
                value = chs[i];
                same = 0;
                other = 0;
                isEqual = false;
            }
            if(chs[i] == value) same++;
            else other++;
            
            if(same == other) isEqual = true;
        }
        answer++;   // 마지막에 하나
        
        return answer;
    }
}