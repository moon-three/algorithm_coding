class Solution {
    public String solution(int n, int t, int m, int p) {     
        StringBuilder all = new StringBuilder();
        int num = 0;
        int length = 0;
        
        while(length < t * m) {
            String s = Integer.toString(num, n).toUpperCase();
            all.append(s);
            num++;
            length += s.length();
        }
        
        StringBuilder answer = new StringBuilder();
        int idx = p - 1;
        
        for(int i = 0; i < t; i++) {
            answer.append(all.charAt(idx));
            idx += m;
        }
        
        return answer.toString();
    }
}