import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] burger = new int[ingredient.length];
        int size = 0;

        for (int j : ingredient) {
            burger[size++] = j;
            if (size >= 4) {
                if (burger[size - 4] == 1 && 
                    burger[size - 3] == 2 && 
                    burger[size - 2] == 3 && 
                    burger[size - 1] == 1) 
                {
                    answer++;
                    size -= 4;
                }
            }
        }

        return answer;
    }
}
