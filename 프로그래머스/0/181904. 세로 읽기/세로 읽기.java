class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        
        int size = my_string.length() % m == 0 ? my_string.length() / m : my_string.length() / m + 1;
        
        char arr[][] = new char[size][m];
        
        int plus = 0;
        
        for(int i = 0; i < size; i++) {
        	for(int j = 0; j < m; j++) {
        		arr[i][j] = my_string.charAt(plus++);
        	}
        }
        
        for(int i = 0; i < size; i++) {
        	answer += arr[i][c-1];
        }
       
        return answer;
    }
}