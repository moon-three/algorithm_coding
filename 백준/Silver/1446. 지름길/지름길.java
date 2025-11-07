import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Way {
    int s, e, d;

    public Way(int s, int e, int d) {
        this.s = s;
        this.e = e;
        this.d = d;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Way> ways = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            ways.add(new Way(s, e, d));
        }

        int[] dp = new int[D+1];
        for(int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        for(int i = 0; i <= D; i++) {
            // 일반길로 가는경우
            if(i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            // 지름길 확인
            for(Way way : ways) {
                if(way.s == i && way.e <= D) {
                    dp[way.e] = Math.min(dp[way.e], dp[i] + way.d);
                }
            }
        }

        System.out.println(dp[D]);
        br.close();
    }
}
