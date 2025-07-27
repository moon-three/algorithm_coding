class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if('a' <= ch && 'z' >= ch) {
                ch -= 32;
            } else {
                ch += 32;
            }
            answer += ch;
        }
        return answer;
    }
}