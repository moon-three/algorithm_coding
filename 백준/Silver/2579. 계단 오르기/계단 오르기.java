import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scores = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] sum = new int[N + 1];

        sum[1] = scores[1];
        if (N >= 2) {
            sum[2] = scores[1] + scores[2];
        } 
        if (N >= 3) {
            sum[3] = Math.max(scores[1] + scores[3], scores[2] + scores[3]);
        }

        for(int i = 4; i <= N; i++) {
            // 124 134
           sum[i] = Math.max(
                   sum[i - 3] + scores[i - 1] + scores[i], // 2칸 + 1칸 오른 경우
                   sum[i - 2] + scores[i]); // 2칸 오른 경우
        }

        System.out.println(sum[N]);
        br.close();

    }
}