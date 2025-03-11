class Solution {
    public int solution(int n, int t) {
        int answer = n;
        int increase = 1;
        
        for(int i = 0; i < t; i++) {
            answer += n * (int)Math.pow(2, i);
        }
        return answer;
    }
}