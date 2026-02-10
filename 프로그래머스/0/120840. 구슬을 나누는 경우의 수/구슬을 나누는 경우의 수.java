class Solution {
    public int solution(int balls, int share) {
        double answer = 1;
        
        for(int i = 1; i <= share; i++) {
            answer *= balls--;
            answer /= i;
        }
        
        return (int) answer;
    }
}