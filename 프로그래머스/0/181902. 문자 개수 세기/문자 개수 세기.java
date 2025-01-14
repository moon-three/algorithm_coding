class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(int i = 0; i < my_string.length(); i++) {
        	
        	int ch = my_string.charAt(i) - 65;
        	if(ch > 25) ch -= 6;
        	
        	answer[ch]++;
        }
        
        return answer;
    }
}