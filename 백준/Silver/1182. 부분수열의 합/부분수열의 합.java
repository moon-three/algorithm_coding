import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0, false);

        System.out.println(cnt);
        br.close();
    }

    public static void dfs(int idx, int sum, boolean selected) {
        if(idx == N) {
            if(selected && sum == S) cnt++;
            return;
        }

        dfs(idx + 1, sum + arr[idx], true);
        dfs(idx + 1, sum, selected);
    }
}