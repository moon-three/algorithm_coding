class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char pushed = 0;
            if(ch == ' ') pushed += ' ';
            else if('a' <= ch && ch <= 'z') {
                pushed = (ch + n) > 'z' ? (char)(ch + n - 26):(char)(ch+n);   
            } else if('A' <= ch && ch <= 'Z') {
                pushed = (ch + n) > 'Z' ? (char)(ch + n - 26):(char)(ch+n);
            }
            answer += pushed;
        }
        
        return answer;
    }
}