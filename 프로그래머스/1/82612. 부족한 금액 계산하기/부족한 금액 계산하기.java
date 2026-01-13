class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long fee = 0;
        for(int i = 1; i <= count; i++) {
            fee += price * i;
        }

        answer = money - fee;
        if(answer < 0) answer *= -1;
        else answer = 0;
    
        return answer;
    }
}