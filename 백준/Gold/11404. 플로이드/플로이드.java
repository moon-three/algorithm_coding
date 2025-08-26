import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    static int N, M;

    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(Collections.nCopies(N+1, null));
        for(int n = 0; n <= N; n++) {
            graph.set(n, new ArrayList<>(Collections.nCopies(N+1, INF)));
        }

        StringTokenizer st;
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int tu = Integer.parseInt(st.nextToken());
            int tv = Integer.parseInt(st.nextToken());
            int tw = Integer.parseInt(st.nextToken());

            graph.get(tu).set(tv, Math.min(graph.get(tu).get(tv), tw));
        }

        // 자기 자신한테 가는 비용은 0
        for(int n = 1; n <= N; n++) {
            graph.get(n).set(n, 0);
        }

        for(int m = 1; m <= N; m++) {
            for(int s = 1; s <= N; s++) {
                for(int e = 1; e <= N; e++) {
                    int min = Math.min(
                            graph.get(s).get(e),
                            graph.get(s).get(m) + graph.get(m).get(e));
                    graph.get(s).set(e, min);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                if(graph.get(r).get(c) == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(graph.get(r).get(c)).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}