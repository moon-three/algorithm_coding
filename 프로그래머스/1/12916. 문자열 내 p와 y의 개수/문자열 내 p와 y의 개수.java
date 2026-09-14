class Solution {
    boolean solution(String s) {

        s = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        
        for(char ch : s.toCharArray()) {
            if(ch == 'p') pCnt++;
            else if(ch == 'y') yCnt++;
        }
        
        return pCnt == yCnt;
    }
}