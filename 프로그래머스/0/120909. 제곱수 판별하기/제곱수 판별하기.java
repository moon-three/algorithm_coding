class Solution {
    public int solution(int n) {
        int answer = 2;
          
        if((int)Math.sqrt((double)n) == Math.sqrt((double)n)) {
        	answer = 1;
        }
        
        return answer;
    }
}