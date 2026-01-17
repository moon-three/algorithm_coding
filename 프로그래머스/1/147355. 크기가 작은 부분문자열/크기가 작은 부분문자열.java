class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int left = 0;
        int right = p.length();
        
        while(right <= t.length()) {
            String cur = t.substring(left, right);
            
            if(Long.parseLong(cur) <= Long.parseLong(p)) {
                answer++;
            }
            
            left++;
            right++;
        }
        
        return answer;
    }
}