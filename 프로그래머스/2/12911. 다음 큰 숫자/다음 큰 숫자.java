class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        String binaryN = Integer.toBinaryString(n);
        for(char ch : binaryN.toCharArray()) {
            if(ch == '1') {
                cnt++;
            } 
        }
        int cur = n+1;
        while(true) {
            int curCnt = 0;
            String curBinary = Integer.toBinaryString(cur);
            for(char ch : curBinary.toCharArray()) {
                if(ch == '1') {
                    curCnt++;
                } 
            }
            if(cur > n && cnt == curCnt) {
                answer = cur;
                break;
            }
            cur++;
        }
        return answer;
    }
}