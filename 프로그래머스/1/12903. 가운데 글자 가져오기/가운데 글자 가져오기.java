class Solution {
    public String solution(String s) {
        
        int midIdx = s.length() / 2;
        
        if(s.length() % 2 == 0) {
            return s.substring(midIdx-1, midIdx+1);
        }
        
        return s.charAt(midIdx) + "";
    }
}