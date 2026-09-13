import java.util.*;

class Solution {
    public long solution(long n) {
        
        String[] sArr = String.valueOf(n).split("");
        Arrays.sort(sArr, (a, b) -> b.compareTo(a));
 
        return Long.parseLong(String.join("", sArr));
    }
}