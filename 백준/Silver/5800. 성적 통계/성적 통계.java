import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for(int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] scores = new int[N];
            for(int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scores);

            int[] gaps = new int[N];
            for(int i = 1; i < N; i++) {
                gaps[i] = scores[i] - scores[i - 1];
            }
            int max = 0;
            for(int gap : gaps) {
                max = Math.max(max, gap);
            }

            sb.append("Class ").append(k).append("\n");
            sb.append("Max ").append(scores[scores.length - 1]).append(", ");
            sb.append("Min ").append(scores[0]).append(", ");
            sb.append("Largest gap ").append(max).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}