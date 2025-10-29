import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {

        final int[] a = {1, 2, 3, 4, 5};
        final int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[4];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == a[i % a.length]) scores[1]++;
            if(answers[i] == b[i % b.length]) scores[2]++;
            if(answers[i] == c[i % c.length]) scores[3]++;
        }

        int max = 0;
        for (int score : scores) {
            max = Math.max(max, score);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < scores.length; i++) {
            if(max == scores[i]) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}