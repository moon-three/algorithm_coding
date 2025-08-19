import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int UND = -1;
    static List<List<Integer>> memo;

    public static int comb(int n, int k) {
        if(n == k || k == 0) {
            return 1;
        }
        if(memo.get(n).get(k) != UND) {
            return memo.get(n).get(k);
        }

        memo.get(n).set(k, comb(n - 1, k - 1) + comb(n - 1, k));

        return memo.get(n).get(k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        memo = new ArrayList<>(Collections.nCopies(N, null));
        for(int i = 0; i < N; i++) {
            memo.set(i, new ArrayList<>(Collections.nCopies(K, UND)));
        }

        // NCK = n-1Ck-1 + n-1Ck;
        System.out.println(comb(N - 1, K - 1));
        br.close();
    }
}