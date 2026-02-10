class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];;
        
        for(int i = 0; i < picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < picture[i].length(); j++) {
                char ch = picture[i].charAt(j);
                for(int t = 0; t < k; t++) {
                    sb.append(ch);
                }
            }
            for(int j = k*i; j < k*i+k; j++) {
                answer[j] = sb.toString();
            }
        }
        
        return answer;
    }
}