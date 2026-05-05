class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char value = 0;
        int same = 0;
        int other = 0;
        for(int i = 0; i < s.length(); i++) {
            if(same == 0) value = s.charAt(i);
            
            if(value == s.charAt(i)) same++;
            else other++;
            
            if(same == other) {
                answer++;
                same = 0;
                other = 0;
            }
        } 
        if(same != 0) answer++;
        
        return answer;
    }
}