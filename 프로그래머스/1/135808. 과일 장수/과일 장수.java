class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        int[] scoreCnt = new int[k + 1];
        
        for(int n : score) {
            scoreCnt[n]++;
        }

        for(int i = k; i > 0; i--) {
            answer += i * (scoreCnt[i] / m) * m;
            scoreCnt[i - 1] += scoreCnt[i] % m;
        }
        
        return answer;
    }
}