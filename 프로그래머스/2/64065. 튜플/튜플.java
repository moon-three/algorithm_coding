import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 문자열 변환
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        s = s.replace("{", "");
        
        String[] arr = s.split("},");
        
        List<String[]> tuple = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            tuple.add(arr[i].split(","));
        }
        // 배열길이 오름차순 정렬
        Collections.sort(tuple, (a,b) -> a.length - b.length);
        
        Set<String> set = new HashSet<>();
        int[] answer = new int[tuple.size()];
        
        for(int i = 0; i < tuple.size(); i++) {
            for(int j = 0; j < tuple.get(i).length; j++) {
                String cur = tuple.get(i)[j];
                if(set.contains(cur)) continue;
                answer[i] = Integer.parseInt(cur);
                set.add(cur);
            } 
        }
          
        return answer;
    }
}