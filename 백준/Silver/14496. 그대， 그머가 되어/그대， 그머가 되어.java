import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] arr = new List[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);

        if(A==B) {
            System.out.println(0);
            return;
        }

        queue.add(A);
        dist[A] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : arr[cur]) {
                if(dist[next] == -1) {
                    dist[next] = dist[cur]+1;
                    queue.add(next);
                }
            }
        }

        System.out.println(dist[B]);
        br.close();
    }
}