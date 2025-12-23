import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int SUBJECT = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] students = new int[N+1][SUBJECT];

        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            for(int s = 0; s < SUBJECT; s++) {
                int score = Integer.parseInt(st.nextToken());
                students[idx][s] = score;
            }
        }

        boolean[] haveGift = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        for(int s = 0; s < SUBJECT; s++) {
            int max = -1;
            int maxIdx = -1;
            for(int n = 1; n <= N; n++) {
                if(!haveGift[n] && students[n][s] > max) {
                    max = students[n][s];
                    maxIdx = n;
                }
            }
            haveGift[maxIdx] = true;
            sb.append(maxIdx).append(" ");
        }

        System.out.println(sb);
        br.close();

    }
}