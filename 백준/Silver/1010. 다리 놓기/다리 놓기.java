// 각각 팩토리얼을 구해서 나누니까 오버플로우 발생

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());       // 서쪽
            int M = Integer.parseInt(st.nextToken());       // 동쪽

            long result = combination(N, M);
            System.out.println(result);
        }

        br.close();
    }

    public static long combination(int N, int M) {
        long result = 1;
        for(int i = 1; i <= N; i++) {
            result = result * (M - i + 1) / i;
        }
        return result;
    }

}