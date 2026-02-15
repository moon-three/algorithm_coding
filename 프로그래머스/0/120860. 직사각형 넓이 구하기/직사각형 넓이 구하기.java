class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        for(int[] dot : dots) {
            if(dots[0][0] == dot[0] || dots[0][1] == dot[1]) continue;
            answer = (Math.abs(dots[0][0] - dot[0])) * (Math.abs(dots[0][1] - dot[1]));
            break;
        }
        
        return answer;
    }
}