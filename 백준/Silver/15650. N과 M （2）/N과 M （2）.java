import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static List<Integer> list;
    static List<Integer> result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N까지 자연수 중 M개를 고른 수열
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // list 초기화
        list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        result = new ArrayList<>();

        dfs(0, 0);

    }

    public static void dfs(int n, int m) {
        if(m == M) {
            sb = new StringBuilder();
            for(int value : result) {
                sb.append(value).append(" ");
            }
            System.out.println(new String(sb).trim());
            return;
        }

        if(n < N && m < M) {
            result.add(list.get(n));
            dfs(n + 1, m + 1);
            result.remove(result.size() - 1);
            dfs(n + 1, m);
        }
    }
}
