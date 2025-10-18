import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Consult {
    int time;
    int price;

    public Consult(int time, int price) {
        this.time = time;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Consult[] consults = new Consult[N+1];
        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            consults[n] = new Consult(t, p);
        }

        int[] dp = new int[N+2];
        for(int n = N; n >= 1; n--) {
            Consult cur = consults[n];
            if(n + cur.time > N + 1) {
                dp[n] = dp[n+1];
                continue;
            }
            dp[n] = Math.max(dp[n+1], cur.price + dp[n + cur.time]);
        }

        System.out.println(dp[1]);
        br.close();
    }
}
