class Solution {
    public int solution(int n) {
        int answer = 1;     // 자기자신인 경우
        
        int left = 1;
        int right = 2;
        int sum = left + right;
        while(left < n) {
            if(sum == n) {
                answer++;
                sum -= left;
                left++;
            } else if(sum < n) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        
        return answer;
    }
}