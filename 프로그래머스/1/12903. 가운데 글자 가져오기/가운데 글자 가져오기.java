class Solution {
    public String solution(String s) {
        String answer = "";
        
        int midIdx = s.length() / 2;
        
        if(s.length() % 2 == 0) {
            answer += s.charAt(midIdx - 1);
        }
        answer += s.charAt(midIdx);
        
        return answer;
    }
}