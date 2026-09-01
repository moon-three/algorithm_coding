class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(true) {
            int zero = 0;
            int one = 0;
            
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') one++;
                else zero++;
            }
            
            s = Integer.toBinaryString(one);
            
            answer[0]++;
            answer[1] += zero;
            
            if(s.equals("1")) break;
        }

        return answer;
    }
}