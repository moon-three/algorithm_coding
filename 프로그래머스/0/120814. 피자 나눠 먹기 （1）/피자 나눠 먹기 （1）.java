class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int piece = 7;
        
        answer += (n / piece);
        if(n % piece > 0) {
        	answer += 1;
        }
        
        return answer;
    }
}