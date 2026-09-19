class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        int idx = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != ' ') {
                if(idx % 2 == 0) {
                    ch -= 32;
                }
                idx++;
            } else {
                idx = 0;
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}