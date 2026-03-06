class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        int diff1 = common[1] - common[0];
        int diff2 = common[2] - common[1];
        
        int last = common[common.length-1];
        if(diff1 == diff2) answer = last + diff1;
        else answer = last * (diff2/diff1);
        
        return answer;
    }
}