import java.util.HashSet;
import java.util.Set;

class Solution {

    Set<Integer> list = new HashSet<>();
    String[] sArr;
    boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;

        sArr = numbers.split("");
        visited = new boolean[sArr.length];

        dfs("", 0);
        
        for (int cur : list) {
            boolean isPrime;
            isPrime = cur > 1;

            for (int i = 2; i * i <= cur; i++) {
                if (cur % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                answer++;
            }
        }

        return answer;
    }

    public void dfs(String s, int depth) {
        if(!s.isEmpty()) {
            list.add(Integer.parseInt(s));
        }

        if(depth == sArr.length) return;

        for(int i = 0; i < sArr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(s + sArr[i], depth + 1);
                visited[i] = false;
            }
        }

    }
}