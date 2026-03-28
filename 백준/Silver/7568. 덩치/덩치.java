import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];

        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[n][0] = Integer.parseInt(st.nextToken());
            people[n][1] = Integer.parseInt(st.nextToken());
        }

        for(int n = 0; n < N; n++) {
            int rank = 1;
            for(int m = 0; m < N; m++) {
                if(people[n][0] < people[m][0] && people[n][1] < people[m][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
        br.close();
    }
}