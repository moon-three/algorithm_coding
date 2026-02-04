class Solution {
    public int solution(int[] numbers, int k) {
    
        if(k==1) return 1;
        
        int idx = 0;
        for(int i = 1; i < k; i++) {
            idx += 2;
            if(idx >= numbers.length) {
                idx %= numbers.length;
            }
        }
        
        return numbers[idx];
    }
}