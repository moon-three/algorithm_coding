class Solution {
    public String solution(String s) {
        boolean isFirst = true;
        
        s = s.toLowerCase();
        char[] chs = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for(char ch : chs) {
            if(ch == ' ') {
                isFirst = true;
            } else {
                if(isFirst && 'a' <= ch && ch <= 'z') {
                    ch = (char)(ch - 32);
                }
                isFirst = false;
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}