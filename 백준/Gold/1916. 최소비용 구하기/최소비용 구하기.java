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
    static final int INF = 123456789;
    static int N, M;

    static List<List<Vertex>> graph;
    static int[] dist;
    static PriorityQueue<Vertex> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(Collections.nCopies(N+1, null));
        for(int n = 1; n <= N; n++) {
            graph.set(n, new ArrayList<>());
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int tu = Integer.parseInt(st.nextToken());
            int tv = Integer.parseInt(st.nextToken());
            int tw = Integer.parseInt(st.nextToken());
            graph.get(tu).add(new Vertex(tv, tw));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[S] = 0;
        pq.add(new Vertex(S, 0));

        while(!pq.isEmpty()) {
            Vertex cur = pq.poll();

            if(dist[cur.v] < cur.w) {
                continue;
            }

            for(Vertex next : graph.get(cur.v)) {
                if(dist[next.v] > cur.w + next.w) {
                    dist[next.v] = cur.w + next.w;
                    pq.add(new Vertex(next.v, dist[next.v]));
                }
            }
        }

        System.out.println(dist[E]);
        br.close();
    }
}