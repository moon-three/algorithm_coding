import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] bestScores = new int[N];

        for(int n = 0; n < N; n++) {
            int[] runs = new int[2];
            int[] tricks = new int[5];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < runs.length; i++) {
                runs[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < tricks.length; i++) {
                tricks[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tricks);

            int score = 0;
            score += Math.max(runs[0], runs[1]);
            score += tricks[tricks.length - 1] + tricks[tricks.length - 2];
            bestScores[n] = score;
        }

        Arrays.sort(bestScores);
        System.out.println(bestScores[N - 1]);
        br.close();
    }
}