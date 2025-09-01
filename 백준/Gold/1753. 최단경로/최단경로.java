import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Vertex implements Comparable<Vertex> {
    int v, w;

    public Vertex(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(this.w, o.w);
    }
}

public class Main {
    static final int INF = 987654321;

    static int V, E, K;
    static List<List<Vertex>> graph;
    static List<Integer> dist;
    static PriorityQueue<Vertex> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>(Collections.nCopies(V+1, null));
        for(int i = 0; i <= V; i++) {
            graph.set(i, new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int tu = Integer.parseInt(st.nextToken());
            int tv = Integer.parseInt(st.nextToken());
            int tw = Integer.parseInt(st.nextToken());

            graph.get(tu).add(new Vertex(tv, tw));
        }
        
        dist = new ArrayList<>(Collections.nCopies(V+1, INF));
        dist.set(K, 0);
        queue.add(new Vertex(K, dist.get(K)));

        while(!queue.isEmpty()) {
            Vertex cur = queue.poll();

            for(Vertex next : graph.get(cur.v)) {
                if(dist.get(next.v) > cur.w + next.w) {
                    dist.set(next.v, cur.w + next.w);
                    queue.add(new Vertex(next.v, dist.get(next.v)));
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            if(dist.get(i) == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist.get(i));
            }
        }
        br.close();

    }
}