class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        
        int sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum += i;
        }
        
        int value = 0;
        for(int i = 0; i < numbers.length; i++) {
            value += numbers[i];
        }
        
        answer = sum - value;
        
        return answer;
    }
}