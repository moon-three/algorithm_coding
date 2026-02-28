import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<int[]> list = new ArrayList<>();
        
        Map<String, Integer> map = Map.of(
            "code", 0,
            "date", 1,
            "maximum", 2,
            "remain", 3
        );
        
        int exp_idx = map.get(ext);
        int sort_idx = map.get(sort_by);
        
        for(int i = 0; i < data.length; i++) {
            if(data[i][exp_idx] < val_ext) {
                list.add(data[i]);
            }
        }
        
        Collections.sort(list, (a, b) -> {
            return a[sort_idx] - b[sort_idx];
        });
        
        int[][] result = new int[list.size()][];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}