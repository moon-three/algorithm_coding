import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for(char ch : X.toCharArray()) {
            xArr[ch-'0']++;
        }
    
        for(char ch : Y.toCharArray()) {
            yArr[ch-'0']++;
        }
            
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 10; i++) {
            if(xArr[i] > 0 && yArr[i] > 0) {
                int range = Math.min(xArr[i], yArr[i]);
                for(int j = 0; j < range; j++) {
                    list.add(i);
                }
            }
        }
        if(list.isEmpty()) return "-1"; // 같은 게 없는 경우는 -1

        Collections.sort(list, Collections.reverseOrder());
        if(list.get(0) == 0) return "0";  // 0으로만 구성된 경우는 0
        
        StringBuilder sb = new StringBuilder();
        for(int i : list) {
            sb.append(i);
        }
        
        return sb.toString();
    }
}