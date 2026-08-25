import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        int[][] table = new int[friends.length][friends.length];
        int[] rate = new int[friends.length];
        int[] result = new int[friends.length];
        
        Map<String, Integer> index = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            index.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            int to = index.get(gift[0]);
            int from = index.get(gift[1]);
            table[to][from]++;
        }
        
        for(int i = 0; i < table.length; i++) {
            int give = 0;
            int take = 0;
            for(int j = 0; j < table[0].length; j++) {
                give += table[i][j];
                take += table[j][i];
            }
            rate[i] = give - take;
        }
        
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table.length; j++) {
                if(i == j) continue;
                int give = table[i][j];
                int take = table[j][i];
                if(give > take) {
                    result[i]++;
                } else if(give == take) {
                    if(rate[i] > rate[j]) result[i]++;
                }
            }
        }
        
        int answer = -1;
        for(int i = 0; i < result.length; i++) {
            answer = Math.max(answer, result[i]);
        }
        
        return answer;
    }
}