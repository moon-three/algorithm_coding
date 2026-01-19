class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String num = "";
        while(n > 0) {
            num += n % 3;
            n /= 3;
        }
        
        for(int i = 0; i < num.length(); i++) {
            answer += (num.charAt(i)-'0') * Math.pow(3, num.length()-i-1);
        }
        
        return answer;
    }
}