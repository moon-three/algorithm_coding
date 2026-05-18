import java.util.*;

class Solution {
    class Num implements Comparable<Num>{
        int num;
        int diff;
        
        public Num(int num, int diff) {
            this.num = num;
            this.diff = diff;
        }
        
        public int compareTo(Num o) {
            if(this.diff == o.diff) return o.num - this.num;
            return Integer.compare(this.diff, o.diff);
        }
    }
    
    public int[] solution(int[] numlist, int n) { 
        Num[] nums = new Num[numlist.length];
        
        for(int i = 0; i < numlist.length; i++) {
            int cur = numlist[i];
            nums[i] = new Num(cur, Math.abs(n - cur));
        }
        
        Arrays.sort(nums);
        
        return Arrays.stream(nums).mapToInt(x -> x.num).toArray();
    }
}