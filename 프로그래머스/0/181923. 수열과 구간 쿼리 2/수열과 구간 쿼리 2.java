import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        
        for(int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            int[] newArr = new int[e-s+1];
            int idx = 0;
            for(int i = s; i <= e; i++) {
                newArr[idx++] = arr[i];
            }
            Arrays.sort(newArr);
            for(int i = 0; i < newArr.length; i++) {
                if(newArr[i] > k) {
                    list.add(newArr[i]);
                    break;
                }
                if(i == newArr.length - 1) {
                    list.add(-1);
                }
            }   
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}