class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pCnt = 0;
        int yCnt = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'p' || ch == 'P') {
                pCnt++;
            } else if(ch == 'y' || ch == 'Y') {
                yCnt++;
            }
        }
        
        answer = pCnt == yCnt ? true : false;
        return answer;
    }
}