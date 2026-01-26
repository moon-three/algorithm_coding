class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            int size = food[i] / 2;
            if(size < 1) continue;
            for(int j = 0; j < size; j++) {
                sb.append(i);
            }
        }
        String str = sb.toString();
        sb.append(0);
        for(int i = str.length()-1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        
        answer = sb.toString();
        return answer;
    }
}