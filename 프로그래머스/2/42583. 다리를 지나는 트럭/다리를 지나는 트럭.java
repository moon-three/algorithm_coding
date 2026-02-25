import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) {    // O(N)
            bridge.offer(0);
        }
        
        int bridgeWeight = 0; // 현재 다리 위 무게
        int time = 0; // 걸리는 시간
        int idx = 0; // 남은 트럭 체크를 위한 idx
        
        while(idx < truck_weights.length) {
            time++;
        
            int cur = bridge.poll();
            bridgeWeight -= cur;
            
            int next = truck_weights[idx];
            
            if(weight >= bridgeWeight + next) {
                bridge.offer(next);
                bridgeWeight += next;
                idx++;
            } else {
                bridge.offer(0);
            }
        }
        // 마지막 트럭이 지나가야 하므로 다리 길이만큼 더하기
        return time + bridge_length;
    }
}