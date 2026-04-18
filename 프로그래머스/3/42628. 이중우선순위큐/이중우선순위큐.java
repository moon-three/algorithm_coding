import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[] {0, 0};
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {
            String[] data = operation.split(" ");
            String op = data[0];
            int value = Integer.parseInt(data[1]);

            if(op.equals("I")) {
                pqAsc.offer(value);
                pqDesc.offer(value);
                map.put(value, map.getOrDefault(value, 0) + 1);
            } else if(op.equals("D")) {
                if(value == 1) {
                    while(!pqDesc.isEmpty() && !map.containsKey(pqDesc.peek())) {
                        pqDesc.poll();
                    }

                    if(!pqDesc.isEmpty()) {
                        int removeValue = pqDesc.poll();
                        map.put(removeValue, map.get(removeValue) - 1);
                        if(map.get(removeValue) == 0) map.remove(removeValue);
                    }

                } else if(value == -1) {
                    while(!pqAsc.isEmpty() && !map.containsKey(pqAsc.peek())) {
                        pqAsc.poll();
                    }

                    if(!pqAsc.isEmpty()) {
                        int removeValue = pqAsc.poll();
                        map.put(removeValue, map.get(removeValue) - 1);
                        if(map.get(removeValue) == 0) map.remove(removeValue);
                    }
                }
            }
        }
        
       while(!pqDesc.isEmpty() && !map.containsKey(pqDesc.peek())) {
            pqDesc.poll();
        }
        while(!pqAsc.isEmpty() && !map.containsKey(pqAsc.peek())) {
            pqAsc.poll();
        }
        
        if(!pqDesc.isEmpty()) answer[0] = pqDesc.poll();
        if(!pqAsc.isEmpty())  answer[1] = pqAsc.poll();

        return answer;
    }
}
