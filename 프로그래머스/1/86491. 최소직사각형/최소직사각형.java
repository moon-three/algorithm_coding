import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        for(int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }

        int maxW = 0, maxH = 0;
        for(int i = 0; i < sizes.length; i++) {
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }

        answer = maxW * maxH;

        return answer;
    }
}