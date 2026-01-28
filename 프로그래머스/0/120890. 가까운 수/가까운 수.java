import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {    
        int[] diff = new int[array.length];
        
        Arrays.sort(array);
        
        for(int i = 0; i < diff.length; i++) {
            diff[i] = Math.abs(n - array[i]);
        }
        
        int minIdx  = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < diff.length; i++) {
            if(diff[i] < min) {
                minIdx = i;
                min = diff[i];
            }
        }
        
        return array[minIdx];
    }
}