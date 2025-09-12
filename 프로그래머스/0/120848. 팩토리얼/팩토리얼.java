class Solution {
    public int solution(int n) {
        
        int value = 1;
        for(int i = 1; i <= 10; i++) {
            value *= i;

            if(value == n) {
                return i;
            } else if(value > n) {
                return i - 1;
            }
        }   
        return -1;
    }
}