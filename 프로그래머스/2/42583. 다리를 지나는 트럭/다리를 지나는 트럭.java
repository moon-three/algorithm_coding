import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) {    // O(N)
            bridge.offer(0);
        }
        
        int bridgeWeight = 0; // 현재 다리 위 무게
        int time = 0; // 걸리는 시간
        int i = 0; // 남은 트럭 체크를 위한 idx
        
        // 아직 트럭이 남아있으면! (다리위에 있든 대기중이든..)
        while(bridgeWeight > 0 || truck_weights.length > i) {
            time++;
        
            int cur = bridge.poll();
            bridgeWeight -= cur;
            
            // 대기 중인 트럭이 있고 가능한 무게면..!
            if(truck_weights.length > i && weight >= bridgeWeight + truck_weights[i]) {
                int next = truck_weights[i++];
                bridge.offer(next);
                bridgeWeight += next;
            } else {
                bridge.offer(0);
            }
        }
        return time;
    }
}