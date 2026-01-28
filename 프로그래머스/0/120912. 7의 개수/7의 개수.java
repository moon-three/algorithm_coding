class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int num : array) {
            sb.append(num);
        }
        for(char ch : sb.toString().toCharArray()) {
            if(ch == '7') {
                answer++;        
            }
        }
        
        return answer;
    }
}