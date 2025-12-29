import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] table = new char[N][N];
        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            table[i] = input;
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                if (i == j) continue;    // 나 자신은 친구가 아님
                if (table[i][j] == 'Y') cnt++;
                else {
                    for(int k = 0; k < N; k++) {
                        if(table[i][k] == 'Y' && table[j][k] == 'Y') {
                            cnt++;
                            break;  // 한명이라도 친구면 stop
                        }
                    }
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
        br.close();
    }
}
