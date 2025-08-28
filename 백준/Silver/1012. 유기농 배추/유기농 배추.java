import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int CABBAGE = 1;
    static final int ROAD = 0;
    static final int UND = 0;
    static final int _n = 0;
    static final int _m = 1;
    static List<List<Integer>> dirs = Arrays.asList(
            Arrays.asList(-1, 0),
            Arrays.asList(1, 0),
            Arrays.asList(0, -1),
            Arrays.asList(0, 1)
    );

    static int T, N, M, K;
    static List<List<Integer>> graph;
    static List<List<Integer>> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>(Collections.nCopies(N, null));
            visited = new ArrayList<>(Collections.nCopies(N, null));

            for (int n = 0; n < N; n++) {
                graph.set(n, new ArrayList<>(Collections.nCopies(M, ROAD)));
                visited.set(n, new ArrayList<>(Collections.nCopies(M, UND)));
            }

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                graph.get(n).set(m, CABBAGE);
            }

            int cnt = 0;

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (graph.get(n).get(m) == CABBAGE && visited.get(n).get(m) == UND) {
                        dfs(n, m);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        br.close();
    }

    static void dfs(int n, int m) {
        visited.get(n).set(m, 1);

        for(List<Integer> dir : dirs) {
            int next_n = n + dir.get(_n);
            int next_m = m + dir.get(_m);

            if(0 <= next_n && next_n < N && 0 <= next_m && next_m < M
                    && graph.get(next_n).get(next_m) == CABBAGE
                    && visited.get(next_n).get(next_m) == UND) {
                dfs(next_n, next_m);
            }
        }
    }

}