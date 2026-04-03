import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sum = new int[N+1][M+1];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= M; m++) {
                int cur = Integer.parseInt(st.nextToken());
                sum[n][m] = cur + sum[n-1][m] + sum[n][m-1] - sum[n-1][m-1];
            }
        }
        
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1  = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}