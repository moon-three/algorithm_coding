import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        final int length = cities.length;
        
        if(cacheSize == 0) return 5 * length;
        
        for(int i = 0; i < length; i++) {
            cities[i] = cities[i].toLowerCase();
        }        
        
        List<String> list = new LinkedList<>();
        int time = 0;
        
        for(int i = 0; i < length; i++) {
            boolean isExist = false;
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j).equals(cities[i])) {
                    list.remove(j);
                    list.add(cities[i]);
                    time += 1;
                    isExist = true;
                    break;
                }
            }
            if(isExist) continue;
            
            if(list.size() == cacheSize) list.remove(0);
            list.add(cities[i]);
            time += 5;
        }
   
        return time;
    }
}