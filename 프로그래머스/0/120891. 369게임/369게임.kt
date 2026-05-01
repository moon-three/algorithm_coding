class Solution {
    fun solution(order: Int): Int {
        var answer: Int = 0
        var num = order
        
        while(num > 0) {
            val cur = num % 10;
            if(cur== 3 || cur == 6 || cur == 9) {
                answer++;
            }
            num /= 10
        }
        
        return answer
    }
}