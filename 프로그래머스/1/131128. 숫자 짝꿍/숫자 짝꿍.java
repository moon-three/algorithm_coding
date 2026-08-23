class Solution {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for(int i = 0; i < X.length(); i++) {
            int idx = X.charAt(i) - '0';
            xArr[idx]++;
        }
        
        for(int i = 0; i < Y.length(); i++) {
            int idx = Y.charAt(i) - '0';
            yArr[idx]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 9; i >= 0; i--) {
            if(xArr[i] != 0 && yArr[i] != 0) {
                int sameCnt = Math.min(xArr[i], yArr[i]);
                for(int j = 0; j < sameCnt; j++) {
                    sb.append(i);
                }
            }
        }
 
        String answer = sb.toString();
        if(answer.isEmpty()) return "-1";
        if(answer.startsWith("0")) return "0";
        return answer;
    }
}