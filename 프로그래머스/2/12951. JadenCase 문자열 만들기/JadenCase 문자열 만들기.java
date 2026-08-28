class Solution {
    public String solution(String s) {

        s = s.toLowerCase();
        
        char[] chs = s.toCharArray();
        boolean isFirst = true;
        
        for(int i = 0; i < chs.length; i++) {
            char ch = chs[i];
  
            if(isFirst) {
                if('a' <= ch && ch <= 'z') {
                    chs[i] = (char) (ch - 32);
                }
                isFirst = false;
            }
            
            if(ch == ' ') {
                isFirst = true;
            }
        }
        
        return new String(chs);
    }
}