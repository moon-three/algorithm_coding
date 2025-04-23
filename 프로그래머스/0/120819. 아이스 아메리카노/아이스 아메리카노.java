class Solution {
    public int[] solution(int money) {
        int[] answer = {};
        
        final int AMERICANO = 5500;
        
        answer = new int[2];
        answer[0] = money / AMERICANO;
        answer[1] = money % AMERICANO;
    
        return answer;
    }
}
