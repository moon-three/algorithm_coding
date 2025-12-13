class Solution {
    public int solution(String number) {
        int answer = 0;
        
        for(int i = 0; i < number.length(); i++) {
        	int num = Integer.parseInt(number.charAt(i) + "");
        	answer += num;
        }
        answer %= 9;
        
        return answer;
    }
}