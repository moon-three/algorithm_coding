class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        String nToStr = String.valueOf(n);
        int length = nToStr.length();
        
        answer = new int[length];
        for(int i = 0; i < length; i++) {
            answer[i] = nToStr.charAt(length - i - 1) - '0';
        }
        
        return answer;
    }
}