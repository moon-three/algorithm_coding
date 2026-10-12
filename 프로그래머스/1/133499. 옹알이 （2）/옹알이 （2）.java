class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < babbling.length; i++) {
            String cur =  babbling[i];
            for(int j = 0; j < words.length; j++) {
                cur = cur.replaceAll(words[j], String.valueOf(j));
            }

            char prev = 0;
            boolean isPossible = true;
            for(int j = 0; j < cur.length(); j++) {
                char ch = cur.charAt(j);
                if(('a' <= ch && ch <= 'z') || ch == prev) {
                    isPossible = false;
                    break;
                }
                prev = ch;
            }
            
            if(isPossible) {
                answer++;
            }
        }
        
        return answer;
    }
}