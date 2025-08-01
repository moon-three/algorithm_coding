class Solution {
    public String solution(int age) {
        String answer = "";
        
        // a = 97
        String[] ageStr = String.valueOf(age).split("");
        for(int i = 0; i < ageStr.length; i++) {
            answer += (char)(97 + Integer.parseInt(ageStr[i]));
        }
        
        return answer;
    }
}