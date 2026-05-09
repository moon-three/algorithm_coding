import java.util.*;

class Solution {    
    public int[] solution(String[] wallpaper) {
        
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        
        for(int i = 0; i < wallpaper.length; i++)  {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    xs.add(i);
                    ys.add(j);
                } 
            }
        }
        
        Collections.sort(xs);
        Collections.sort(ys);
  
        int[] answer = new int[4];
        answer[0] = xs.get(0);
        answer[1] = ys.get(0);
        answer[2] = xs.get(xs.size()-1)+1;
        answer[3] = ys.get(ys.size()-1)+1;
        
        return answer;
    }
}