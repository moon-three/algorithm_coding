import java.util.*;

class Solution {
    class Play implements Comparable<Play> {
        int idx;
        int play;
        
        public Play(int idx, int play) {
            this.idx = idx;
            this.play = play;            
        }
        
        public int compareTo(Play other) {
            if(this.play == other.play) return this.idx - other.idx;
            return other.play - this.play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int length = genres.length;
        
        Map<String, Integer> totalPlayMap = new HashMap<>();
        Map<String, List<Play>> genreMap = new HashMap<>();
        
        for(int i = 0; i < length; i++) {
            totalPlayMap.put(genres[i], totalPlayMap.getOrDefault(genres[i], 0) + plays[i]);
            List<Play> list = genreMap.getOrDefault(genres[i], new ArrayList<>());
            list.add(new Play(i, plays[i]));
            genreMap.put(genres[i], list);
        }
        
        for(Map.Entry<String, List<Play>> entry : genreMap.entrySet()) {
            Collections.sort(entry.getValue());           
        }
        
        List<String> list = new ArrayList<>(totalPlayMap.keySet());
        Collections.sort(list, (a, b) -> totalPlayMap.get(b) - totalPlayMap.get(a));
        
        List<Integer> answer = new ArrayList<>();
        for(String s : list) {
            List<Play> cur = genreMap.get(s);
            answer.add(cur.get(0).idx);
            if(cur.size() >= 2) answer.add(cur.get(1).idx);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}