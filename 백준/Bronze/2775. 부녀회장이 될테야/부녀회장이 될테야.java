import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 최대 입력값 14 (14층 14호)
        int[][] mat = new int[15][15];

        // 아파트 0층 초기화
        for(int i = 1; i < 15; i++) {
            mat[0][i] = i;
        }

        // 아파트 1층~14층 사람 수
        for(int i = 1; i < 15; i++) {
            for(int j = 1; j < 15; j++) {
                mat[i][j] = mat[i][j - 1] + mat[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(mat[k][n]).append("\n");
        }

        System.out.println(sb);
        br.close();

    }
}