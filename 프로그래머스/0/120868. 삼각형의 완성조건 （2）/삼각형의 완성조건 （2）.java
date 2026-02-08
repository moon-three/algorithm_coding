import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] sides) {
        Set<Integer> set = new HashSet<>();
        
        Arrays.sort(sides);
        
        for(int i = sides[1]-sides[0]+1; i <= sides[1]; i++) {
            set.add(i);
        }
        
        for(int i = sides[1]+1; i < sides[0]+sides[1]; i++) {
            set.add(i);
        }

        return set.size();
    }
}