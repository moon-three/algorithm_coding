import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static Queue<Integer> queue = new LinkedList<>();
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        count = new int[N+1];
        for(int n = 1; n <= N; n++) {
            graph[n] = new ArrayList<>();
        }
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph[E].add(S);
        }

        int max = 0;
        for(int n = 1; n <= N; n++) {
            visited = new boolean[N+1];
            bfs(n);
            max = Math.max(count[n], max);
        }

        StringBuilder sb = new StringBuilder();
        for(int n = 1; n <= N; n++) {
            if(count[n] == max) {
                sb.append(n).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void bfs(int n) {
        queue.add(n);
        visited[n] = true;

        int cnt = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph[cur]) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        count[n] = cnt;
    }
}