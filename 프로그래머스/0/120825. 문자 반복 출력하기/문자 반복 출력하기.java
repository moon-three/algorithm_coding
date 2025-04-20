class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        char[] cArr = my_string.toCharArray();
        
        for(int i = 0; i < cArr.length; i++) {
        	char ch = cArr[i];
        	for(int j = 0; j < n; j++) {
        		answer += ch;
        	}
        }
        
        return answer;
    }
}