import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 랜선 수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        int[] lines = new int[K];
        int max = 0;
        for(int k = 0; k < K; k++) {
            lines[k] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[k]);
        }

        long start = 1;
        long end = max;
        long result = 0;
        while(start <= end) {
            long mid = (end-start) / 2 + start;
            long cnt = 0;
            for (int line : lines) {
                cnt += line / mid;
            }

            if(cnt < N) {
                end = mid - 1;
            } else {
                result = Math.max(result, mid);
                start = mid + 1;
            }
        }

        System.out.println(result);
        br.close();
    }
}
