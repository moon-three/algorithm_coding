class Solution {
    public boolean solution(String s) {
        
        if(s.length() != 4 && s.length() != 6) return false;
        
        char[] chs = s.toCharArray();
        
        for(int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if('0' <= ch && ch <= '9') continue;
            return false;
        }
        
        return true;
    }
}