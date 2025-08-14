class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = {};
        int length = emergency.length;
        answer = new int[length];
        
        for(int i = 1; i <= length; i++) {
        int max = 0;
        int maxIdx = -1;
            for(int j = 0; j < length; j++) {
                if(emergency[j] > max) {
                    max = emergency[j];
                    maxIdx = j;
                }   
            }
            answer[maxIdx] = i;
            emergency[maxIdx] = 0;         
        }
        
        return answer;
    }
}