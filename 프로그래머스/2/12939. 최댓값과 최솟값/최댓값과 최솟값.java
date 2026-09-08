import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int[] arr = Arrays.stream(sArr).mapToInt(o -> Integer.parseInt(o)).toArray();
        Arrays.sort(arr);
        
        return arr[0] + " " + arr[arr.length - 1];
    }
}