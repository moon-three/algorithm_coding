class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        my_string = my_string.replaceAll("[a-zA-z]", " ");
        String[] sArr = my_string.split(" ");
        for(String s : sArr) {
            if(!s.equals("")) {
                answer += Integer.parseInt(s);
            }
        }
        
        return answer;
    }
}