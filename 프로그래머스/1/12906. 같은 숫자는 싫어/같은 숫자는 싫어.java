import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(i != 0 && arr[i-1] == arr[i]) continue;
            list.add(arr[i]);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}