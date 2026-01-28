class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        
        int length = my_str.length() % n == 0 ? my_str.length() / n : my_str.length() / n + 1;
        answer = new String[length];
        
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < my_str.length(); i++) {
            sb.append(my_str.charAt(i));
            cnt++;
            if(cnt % n == 0) {
                answer[cnt / n - 1] = sb.toString();
                sb.setLength(0);
            }
        }
        if(sb.length() > 0) {
            answer[answer.length - 1] = sb.toString();
        }
        
        return answer;
    }
}