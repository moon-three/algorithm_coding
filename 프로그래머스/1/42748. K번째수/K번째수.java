import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] cmd = commands[i];
            int start = cmd[0] - 1;
            int end = cmd[1] - 1;
            int value = cmd[2] - 1;
            
            List<Integer> list = new ArrayList<>();
            
            for(int j = start; j <= end; j++) {
                list.add(array[j]);
            }
            
            Collections.sort(list);
            
            answer[i] = list.get(value);
        }

        return answer;
    }
}