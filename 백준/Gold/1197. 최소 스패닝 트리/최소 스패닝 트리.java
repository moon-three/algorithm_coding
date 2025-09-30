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
    static int V, E;

    static List<Edge> edges;
    static int[] set;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int tu = Integer.parseInt(st.nextToken());
            int tv = Integer.parseInt(st.nextToken());
            int tw = Integer.parseInt(st.nextToken());

            edges.add(new Edge(tu, tv, tw));
        }

        Collections.sort(edges);

        set = new int[V+1];
        for(int v = 1; v <= V; v++) {
            set[v] = v;
        }

        for(Edge e : edges) {
            if(find(e.u) != find(e.v)) {
                union(e.u, e.v);
                result += e.w;
            }
        }

        System.out.println(result);
        br.close();
    }

    static int find(int a) {
        if(a != set[a]) {
            set[a] = find(set[a]);
        }
        return set[a];
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        set[b] = a;
    }

}