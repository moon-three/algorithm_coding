class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        for(char ch : my_string.toCharArray()) {
            if('0' <= ch && ch <= '9') {
                sb.append(ch);
            } else if(!sb.toString().equals("")) {
                answer += Integer.parseInt(sb.toString());
                sb.setLength(0);
            }
        }
        
        if(!sb.toString().equals("")) {
                answer += Integer.parseInt(sb.toString());
                sb.setLength(0);
        }
        
        return answer;
    }
}