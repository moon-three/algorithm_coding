import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list;

    static int[] dist;

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>(Collections.nCopies(N+1, null));
        for(int n = 1; n <= N; n++) {
            list.set(n, new ArrayList<>());
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        dist = new int[N+1];
        Arrays.fill(dist, -1);

        queue.add(1);
        dist[1] = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : list.get(cur)) {
                if(dist[next] != -1) {
                    continue;
                }
                dist[next] = dist[cur] + 1;
                queue.add(next);
            }
        }

        int num = 0;
        int distance = 0;
        int cnt = 0;

        for(int i = 1; i <= N; i++) {
            if(distance < dist[i]) {
                num = i;
                distance = dist[i];
                cnt = 1;
            } else if(distance == dist[i]) {
                cnt++;
            }
        }

        System.out.print(num + " " + distance + " " + cnt);
        br.close();
    }
}