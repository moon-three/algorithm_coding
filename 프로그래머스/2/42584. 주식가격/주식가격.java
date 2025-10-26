import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < prices.length; i++) {
            queue.add(prices[i]);
        }

        int i = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int cnt = 0;

            for(int next : queue) {
                cnt++;
                if(next < cur) {
                    break;
                }
            }
            answer[i++] = cnt;
        }
        return answer;
    }
}