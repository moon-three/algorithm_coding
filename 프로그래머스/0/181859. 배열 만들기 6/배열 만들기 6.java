import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(list.isEmpty()) {
                list.add(arr[i]);
                continue;
            }
            int last = list.get(list.size()-1);
            if(last == arr[i]) list.remove(list.size()-1);
            else list.add(arr[i]);
        }
        
        if(list.isEmpty()) return new int[]{-1};
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}