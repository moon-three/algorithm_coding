class Solution {
    public int solution(int n) {
        int cnt = 1;
        int value = 1;
        
        while(cnt < n) {
            value++;
            if(value % 3 == 0 || String.valueOf(value).contains("3")) {
                continue;
            }
            cnt++;
        }
        
        return value;
    }
}