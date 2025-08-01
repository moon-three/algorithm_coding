class Solution {
    public int solution(int order) {
        int answer = 0;
        
        String[] str = String.valueOf(order).split("");
        for(int i = 0; i < str.length; i++) {
            int now = Integer.parseInt(str[i]);
            if(now != 0 && now % 3 == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}