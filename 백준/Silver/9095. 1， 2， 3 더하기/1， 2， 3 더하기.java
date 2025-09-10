import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int T, N;

    static final int INF = -1;
    static List<Integer> memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        memo = new ArrayList<>(Collections.nCopies(12, INF));

        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(f(N));
        }
        br.close();
    }

    static int f(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        if(memo.get(n) != INF) {
            return memo.get(n);
        }

        memo.set(n, f(n - 1) + f(n - 2) + f(n - 3));
        return memo.get(n);
    }
}