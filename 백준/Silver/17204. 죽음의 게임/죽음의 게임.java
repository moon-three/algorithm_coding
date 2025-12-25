import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        int cnt = 0;
        while(true) {
            if(idx == K) {
                System.out.println(cnt);
                break;
            }
            if(visited[idx]) {
                System.out.println(-1);
                break;
            }
            visited[idx] = true;
            idx = arr[idx];
            cnt++;
        }

        br.close();
    }
}
