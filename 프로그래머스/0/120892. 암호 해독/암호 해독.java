class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        
        int cnt = 1;
        
        for(int i = 0; i < cipher.length(); i++) {
            if(cnt % code == 0) {
                answer += cipher.charAt(i) + "";
            }
                cnt++;
        }
        
        return answer;
    }
}