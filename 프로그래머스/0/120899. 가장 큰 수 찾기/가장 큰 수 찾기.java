class Solution {
    public int[] solution(int[] array) {
        int[] answer = {};
        
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        
        for(int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
                maxIdx = i;
            }
        }
        
        answer = new int[] {max, maxIdx};
        
        return answer;
    }
}