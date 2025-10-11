import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int T, V, E;
    static ArrayList<Integer>[] graph;
    static int[] set;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            graph = new ArrayList[V+1];
            for(int v = 1; v <= V; v++) {
                graph[v] = new ArrayList<>();
            }
            for(int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            // 집합 표시
            set = new int[V+1];
            flag = true;
            // 연결된 정점을 번갈아 가면서 집합에 넣는다
            for(int v = 1; v <= V; v++) {
                if(set[v] == 0) {
                    dfs(v, 1);
                }
                if(!flag) {
                    break;
                }
            }
            System.out.println(flag? "YES" : "NO");
        }
        br.close();
    }

    public static void dfs(int node, int group) {
        set[node] = group;

        for(int next : graph[node]) {
            if(set[next] == 0) {
                dfs(next, -group);
            } else if(set[next] == group){
                flag = false;
                return;
            }
        }
    }
}