import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if(arr.length == 1) return new int[]{-1};
        
        int min = Integer.MAX_VALUE;
        for(int n : arr) {
            min = Math.min(min, n);
            list.add(n);
        }
        
        list.remove(Integer.valueOf(min));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}