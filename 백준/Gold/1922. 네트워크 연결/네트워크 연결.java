import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int u, v, w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w, o.w);
    }
}

public class Main {
    static int N, M;

    static List<Edge> list;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int tu = Integer.parseInt(st.nextToken());
            int tv = Integer.parseInt(st.nextToken());
            int tw = Integer.parseInt(st.nextToken());

            list.add(new Edge(tu, tv, tw));
        }

        Collections.sort(list); // 가중치 기준 오름차순

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int result = 0;
        for(Edge e : list) {
            int u = e.u;
            int v = e.v;

            if(find(u) != find(v)) {
                union(u, v);
                result += e.w;
            }
        }
        System.out.println(result);
        br.close();
    }

    static int find(int n) {
        if(parent[n] == n) {
            return n;
        }
        parent[n] = find(parent[n]);
        return parent[n];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }
}

