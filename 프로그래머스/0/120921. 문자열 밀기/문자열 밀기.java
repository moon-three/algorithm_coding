class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        for(int i = 0; i < B.length(); i++) {
            if(B.charAt(i) == A.charAt(0)) {
                boolean result = checkWords(A, B, i);
                if(result) return i;
            }
        }
        return -1;
    }
    
    public boolean checkWords(String A, String B, int idx) {
        for(int i = 0; i < A.length(); i++) {
            int index = idx+i >= B.length() ? (idx+i)%B.length() : idx+i;
            if(A.charAt(i) != B.charAt(index)) {
                return false;
            }
        }
        return true;
    }
    
}