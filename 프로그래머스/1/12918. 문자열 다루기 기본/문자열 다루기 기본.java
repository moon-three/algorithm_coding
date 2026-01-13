class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        int length = s.length();
        
        if(length != 4 && length != 6) return false;
        
        for(int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if(!('0' <= ch && ch <= '9')) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}