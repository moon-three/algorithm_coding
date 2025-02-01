class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        
        for(int[] query : queries) {
        	my_string = reverseWord(my_string, query);
        }
        
        answer = my_string;
        
        return answer;
    }
    
    public String reverseWord(String s, int[] arr) {
    	
    	int start = arr[0];
    	int end = arr[1];
    	char[] cArr = s.toCharArray();
    	
    	while (start < end) {
    		char tmp = cArr[start];
    		cArr[start] = cArr[end];
    		cArr[end] = tmp;
    		
    		start++;
    		end--;
    	}	
    	return new String(cArr);
    }
}