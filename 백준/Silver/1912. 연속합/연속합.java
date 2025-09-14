import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int result = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            sum = sum + cur;
            result = Math.max(result, sum);
            sum = Math.max(sum, 0);
        }

        System.out.println(result);
        br.close();
    }
}
