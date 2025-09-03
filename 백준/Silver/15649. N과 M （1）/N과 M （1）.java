import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;

    static List<Integer> result = new ArrayList<>();  // 수열을 담을 리스트
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N+1];
        dfs(0);

        System.out.println(sb);
        sc.close();
    }

    public static void dfs(int depth) {
        if(depth == M) {
            for(int n : result) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result.add(i);
                dfs(depth + 1);
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }

}