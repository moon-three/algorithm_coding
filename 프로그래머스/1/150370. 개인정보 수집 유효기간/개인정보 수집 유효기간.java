import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        
        Map<String, Integer> termMap = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String[] termArr = terms[i].split(" ");
            termMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] date = privacy[0].split("\\.");

            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            
            int term = termMap.get(privacy[1]);
            
            month += term;
            
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
            
            int expired = Integer.parseInt(String.format("%04d%02d%02d", year, month, day));
            int todayToInt = Integer.parseInt(today.replace(".", ""));
            if(expired <= todayToInt) result.add(i+1);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}