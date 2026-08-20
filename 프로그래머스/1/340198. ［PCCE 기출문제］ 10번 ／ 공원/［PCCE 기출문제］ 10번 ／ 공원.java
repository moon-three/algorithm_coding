import java.util.*;

class Solution {
    String[][] _park;
    
    public int solution(int[] mats, String[][] park) {
        _park = park;
        int n = park.length;
        int m = park[0].length;

        Arrays.sort(mats);
        
        for(int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            for(int r = 0; r <= n - size; r++) {
                for(int c = 0; c <= m - size; c++) {
                    if(canPlace(r, c, size)) {
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
    
    boolean canPlace(int r, int c, int size) {
        
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(!_park[i][j].equals("-1")) return false;
            }
        }
        
        return true;
    }
}