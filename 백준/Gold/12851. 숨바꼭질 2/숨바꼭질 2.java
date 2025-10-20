import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100001;

    static int[] dist;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dist = new int[MAX];    // 0~10000
        count = new int[MAX];

        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;
        count[N] = 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : Arrays.asList(cur - 1, cur + 1, cur * 2)) {
                if(next < 0 || next >= MAX) {
                    continue;
                }

                if(dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    count[next] = count[cur];
                    queue.add(next);
                } else if(dist[next] == dist[cur] + 1) {    // 같은 시간에 해당 지점에 도착했으면 개수 추가
                    count[next] += count[cur];
                }

            }
        }

        System.out.println(dist[K]);
        System.out.println(count[K]);
        br.close();

    }
}