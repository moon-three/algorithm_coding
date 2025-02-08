class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        
        String[] sArr = my_string.split("");
        for(int i = 0; i < sArr.length; i++) {
        	if(!sArr[i].equals(letter)) {
        		answer += sArr[i];
        	}
        }
        
        return answer;
    }
}
