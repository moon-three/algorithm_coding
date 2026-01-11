import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[1]);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    static void dfs(int idx, int cur) {
        if(idx == N) {
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }
        idx++;

        for(int i = 0; i < 4; i++) {
            if(operator[i] > 0) {
                operator[i]--;

                int next = cur;
                if(i == 0) next = cur + numbers[idx];
                else if(i == 1) next = cur - numbers[idx];
                else if(i == 2) next = cur * numbers[idx];
                else next = cur / numbers[idx];

                dfs(idx, next);
                operator[i]++;
            }
        }
    }
}
