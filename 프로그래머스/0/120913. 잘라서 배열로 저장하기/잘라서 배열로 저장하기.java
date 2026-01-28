class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        int length = my_str.length() % n == 0? my_str.length() / n : my_str.length() / n + 1;
        answer = new String[length];
        
        for(int i = 0; i < my_str.length(); i += n) {
            if(i+n > my_str.length()) {
                answer[i / n] = my_str.substring(i, my_str.length());
            } else {
                answer[i / n] = my_str.substring(i, i+n);
            }
        }
        
        return answer;
    }
}