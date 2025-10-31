import java.util.Arrays;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int total = brown + yellow;

        int height = 3;
        while(true) {
            int h = height;
            int w = total / h;
            if(h * w == total && (h-2) * (w-2) == yellow) {
                answer = new int[]{w,h};
                break;
            }
            height++;
        }
        return answer;
    }
}