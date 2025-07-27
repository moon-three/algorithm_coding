class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        
        String[] sArr = my_string.split("");
        String tmp = sArr[num1];
        sArr[num1] = sArr[num2];
        sArr[num2] = tmp;
        
        answer = String.join("", sArr);
        
        return answer;
    }
}