import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue= new LinkedList<>();

        for(int i =  0; i < progresses.length; i++) {
            int remaining = (100 - progresses[i]);
            int day = remaining % speeds[i] == 0 ? (remaining / speeds[i]) : (remaining / speeds[i]) + 1;
            queue.add(day);
        }

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int cnt = 1;

            // 지금 작업이 다음 작업보다 더 오래 걸렸으면
            while(!queue.isEmpty() && cur >= queue.peek()) {
                queue.poll();
                cnt++;
            }

            result.add(cnt);
        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}