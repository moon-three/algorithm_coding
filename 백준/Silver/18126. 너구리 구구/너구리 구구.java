import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Room {
    int num;
    int distance;

    public Room(int num, int distance) {
        this.num = num;
        this.distance = distance;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Room>[] rooms = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            rooms[i] = new ArrayList<>();
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist, -1);

        for(int n = 0; n < N-1; n++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            rooms[u].add(new Room(v, w));
            rooms[v].add(new Room(u, w));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(Room next : rooms[cur]) {
                if(dist[next.num]==-1) {
                    dist[next.num] = dist[cur] + next.distance;
                    queue.add(next.num);
                }
            }
        }

        long max = 0;
        for(long n : dist) {
            max = Math.max(max, n);
        }
        System.out.println(max);
        br.close();
    }
}