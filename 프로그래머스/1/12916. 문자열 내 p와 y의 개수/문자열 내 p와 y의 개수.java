class Solution {
    boolean solution(String s) {
        
        s = s.toLowerCase();
        int pcnt = 0;
        int ycnt = 0;
        for(char ch : s.toCharArray()) {
            if(ch == 'p') pcnt++;
            else if(ch == 'y') ycnt++;
        }
        
        return pcnt == ycnt;
    }
}