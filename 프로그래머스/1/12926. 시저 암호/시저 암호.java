class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                sb.append(ch);
                continue;
            }
            char next = (char)(ch + n);
            if(('a' <= ch && ch <= 'z') && 'z' < next) {
                next -= 26;
            } 
            if(('A' <= ch && ch <= 'Z') && 'Z' < next) {
                next -= 26;
            }
            sb.append(next);
        }

        return sb.toString();
    }
}