import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Map<Integer, Integer>[] arr = new HashMap[N+1];
        for(int n = 0; n <= N; n++) {
            arr[n] = new HashMap<>();
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(arr[u].containsKey(v)) {
                w = Math.min(arr[u].get(v), w);
            }
            arr[u].put(v, w);
            arr[v].put(u, w);
        }

        StringBuilder sb = new StringBuilder();
        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(arr[s].containsKey(e)) {
                sb.append(arr[s].get(e)).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}