import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int N = photo.length;
        int[] answer = new int[N];
        
        List<String> list = Arrays.asList(name);
        
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(String s : photo[i]) {
                if(list.contains(s)) {
                    int idx = list.indexOf(s);
                    sum += yearning[idx];
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}