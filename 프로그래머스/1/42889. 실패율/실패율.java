import java.util.*;

class Solution {
    class Stage implements Comparable<Stage>{
        double failure;
        int num;
        
        public Stage(double failure, int num) {
            this.failure = failure;
            this.num = num;
        }
        
        public int compareTo(Stage o) {
            if(this.failure == o.failure) return this.num - o.num;
            return Double.compare(o.failure, this.failure);
        }
        
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int stage : stages) {
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }
        
        int user = stages.length;
        Stage[] sArr = new Stage[N];
        for(int i = 0; i < N; i++) {
            int level = i + 1;
            
            if(user == 0) {     // user가 0이면 실패율은 0
                sArr[i] = new Stage(0, level);
                continue;
            }
            
            int notClear = 0;   // 도달했지만 클리어하지 못한 플레이어
            if(map.containsKey(level)) {
               notClear = map.get(level); 
            }
            double failure = (double) notClear / user;
            sArr[i] = new Stage(failure, level);
            user -= notClear;
        }
        Arrays.sort(sArr);
        
        for(int i = 0; i < N; i++) {
            answer[i] = sArr[i].num;
        }
        
        return answer;
    }
}