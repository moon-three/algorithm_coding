class Solution {
    public int[] solution(String s) {
       int[] answer = new int[2];
        
        while(!s.equals("1")) {
            int preLength = s.length();
            s = s.replaceAll("0", "");
            int curLength = s.length();
            answer[1] += preLength - curLength;

            s = Integer.toBinaryString(curLength);
            answer[0]++;
        }
        
        return answer;
    }
}