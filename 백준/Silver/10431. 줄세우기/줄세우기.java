import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for(int n = 1; n <= N; n++) {
            int[] arr = new int[20];
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            for(int i = 0; i < 20; i ++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for(int i = 1; i < 20; i++) {
                int cur = arr[i];
                for(int j = 0; j < i; j++) {
                    if(arr[j] > cur) {
                        cnt++;
                    }
                }
            }
            sb.append(num).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}