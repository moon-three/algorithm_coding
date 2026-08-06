import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        
        for(int i = 0; i < report.length; i++) {
            String id1 = report[i].split(" ")[0];
            String id2 = report[i].split(" ")[1];
            
            Set<String> set = reportMap.getOrDefault(id2, new HashSet<>());
            set.add(id1);
            reportMap.put(id2, set);
        }
        
        for(int i = 0; i < id_list.length; i++) {
            result.put(id_list[i], 0);
        }
        
        for(String s : reportMap.keySet()) {
            Set<String> reporters = reportMap.get(s);
            
            if(reporters.size() >= k) {
                for(String r : reporters) {
                    result.put(r, result.get(r) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = result.get(id_list[i]);
        }
        
        return answer;
    }
}