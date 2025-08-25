import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    static int N;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(Collections.nCopies(N+1, null));
        for(int n = 0; n <= N; n++) {
            graph.set(n, new ArrayList<>(Collections.nCopies(N+1, INF)));
        }

        for(int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= N; c++) {
                int data = Integer.parseInt(st.nextToken());
                graph.get(r).set(c, data == 0 ? INF : data);
            }
        }

        for(int m = 1; m <= N; m++) {
            for(int s = 1; s <= N; s++) {
                for(int e = 1; e <= N; e++) {
                    graph.get(s).set(e, Math.min(
                               graph.get(s).get(e),
                            graph.get(s).get(m) + graph.get(m).get(e)
                    ));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                if(graph.get(r).get(c) == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(1).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
