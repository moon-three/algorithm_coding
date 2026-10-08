import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[4];
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % one.length]) scores[1]++;
            if(answers[i] == two[i % two.length]) scores[2]++;
            if(answers[i] == three[i % three.length]) scores[3]++;
        }
        
        int max = 0;
        for(int i = 1; i < scores.length; i++) {
            if(max < scores[i]) max = scores[i];
        }
   
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < scores.length; i++) {
            if(scores[i] == max) result.add(i);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}