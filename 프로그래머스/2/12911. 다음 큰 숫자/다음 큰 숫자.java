class Solution {
    public int solution(int n) {

        String nBinary = Integer.toBinaryString(n);
        int nCnt = 0;
        
        for(int i = 0; i < nBinary.length(); i++) {
            if(nBinary.charAt(i) == '1') nCnt++;
        }
        
        while(true) {
            String next = Integer.toBinaryString(++n);
            int cnt = 0;
            
            for(int i = 0; i < next.length(); i++) {
                if(next.charAt(i) == '1') cnt++;
            }
            
            if(cnt == nCnt) return n;
        }

    }
}