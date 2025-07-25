import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        
        int length = numbers.length;
        
        int value1 = numbers[0] * numbers[1];
        int value2 = numbers[length - 1] * numbers[length - 2];
        
        answer = Math.max(value1, value2);
        
        return answer;
    }
}