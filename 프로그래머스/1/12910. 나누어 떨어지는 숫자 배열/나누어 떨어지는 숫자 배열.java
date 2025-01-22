import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        Arrays.sort(arr);
        
        answer = IntStream.of(arr).filter(x -> x % divisor == 0).toArray();
        
        if(answer.length == 0) {
        	answer = new int[] {-1};
        }
    
        return answer;
    }
}