class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        
        int d1 = Integer.parseInt(bin1, 2);
        int d2 = Integer.parseInt(bin2, 2);
        answer = Integer.toBinaryString(d1 + d2);
        
        return answer;
    }
}