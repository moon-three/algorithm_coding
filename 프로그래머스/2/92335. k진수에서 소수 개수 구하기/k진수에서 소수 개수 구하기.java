class Solution {
    public int solution(int n, int k) {
        
        String nToS = Integer.toString(n, k);
        String[] sArr = nToS.split("0");
        
        int cnt = 0;
        for(int i = 0; i < sArr.length; i++) {
            if(sArr[i].equals("")) continue;
            long cur = Long.parseLong(sArr[i]);
            if(cur < 2) continue;
            boolean isPrime = true;
            for(long j = 2; j * j <= cur; j++) {
                if(cur % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                cnt++;
            }
        }
        
        return cnt;
    }
}