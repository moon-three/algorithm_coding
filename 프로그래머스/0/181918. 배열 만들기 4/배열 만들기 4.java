import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) { 
        int[] stk = {};
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            while(!list.isEmpty() && list.get(list.size()-1) >= arr[i]) {
                list.remove(list.size()-1);
            }
            list.add(arr[i]);
        }
        
        stk = list.stream().mapToInt(Integer::intValue).toArray();
        return stk;
    }
}