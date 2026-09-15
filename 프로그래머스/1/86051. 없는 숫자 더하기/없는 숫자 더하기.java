class Solution {
    public int solution(int[] numbers) {   
        int total = 0;
        for(int i = 1; i < 10; i++) {
            total += i;
        }
        
        int value = 0;
        for(int i = 0; i < numbers.length; i++) {
            value += numbers[i];
        }
        
        return total - value;
    }
}