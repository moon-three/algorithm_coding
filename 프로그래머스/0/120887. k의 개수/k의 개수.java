class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int n = i; n <= j; n++) {
            char[] arr = String.valueOf(n).toCharArray();
            for(char ch : arr) {
                if(ch - '0' == k) {
                    answer++;
                }
            }         
        }
        
        return answer;
    }
}