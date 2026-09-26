class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            int len = food[i] / 2;
            for(int j = 0; j < len; j++) {
                sb.append(i);
            }
        }
        
        String mid = sb.toString();
        sb.append(0);
        
        for(int i = mid.length() - 1; i >= 0; i--) {
            sb.append(mid.charAt(i));
        }

        return sb.toString();
    }
}