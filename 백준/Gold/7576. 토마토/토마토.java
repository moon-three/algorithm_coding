import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int GOOD = 1;
    static final int BAD = 0;

    static final int _n = 0;
    static final int _m = 1;
    static List<List<Integer>> dirs = Arrays.asList(
            Arrays.asList(-1, 0),
            Arrays.asList(1, 0),
            Arrays.asList(0, -1),
            Arrays.asList(0, 1)
    );

    static int M;
    static int N;
    static int[][] graph;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= M; m++) {
                int data = Integer.parseInt(st.nextToken());
                graph[n][m] = data;
            }
        }

        // 익은 토마토들을 큐에 넣는다
        for(int n = 1; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                if(graph[n][m] == GOOD) {
                    queue.add(new int[]{n, m});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[_n];
            int m = cur[_m];

            for(List<Integer> dir : dirs) {
                int next_n = n + dir.get(_n);
                int next_m = m + dir.get(_m);

                if(0 < next_n && next_n <= N
                    && 0 < next_m && next_m <= M
                    && graph[next_n][next_m] == BAD) {
                    graph[next_n][next_m] = graph[n][m] + 1;
                    queue.add(new int[]{next_n, next_m});
                }
            }
        }

        int result = 0;
        boolean impossible = false;
        for(int n = 1; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                int cur = graph[n][m];

                if(cur == BAD) {
                    impossible = true;
                    break;
                }

                result = Math.max(result, cur);
            }
            if(impossible) break;
        }
        System.out.println(impossible ? -1 : result - 1);
        br.close();
    }
}