class Solution {
    public String solution(String s) {
        String answer = "";
       
        String[] sArr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < sArr.length; i++) {
            int cur = Integer.parseInt(sArr[i]);
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}