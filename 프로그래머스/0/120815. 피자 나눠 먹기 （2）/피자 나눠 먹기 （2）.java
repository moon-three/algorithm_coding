class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 6; i <= 600; i += 6) {
            if(i % n == 0) {
                answer = i;
                break;
            }
        }       
        answer /= 6;
        return answer;
    }
}