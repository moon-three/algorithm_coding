import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for(int i = 0; i < 5; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            if(arr[3] - arr[1] >= 4) {
                System.out.println("KIN");
            } else {
                System.out.println(arr[1] + arr[2] + arr[3]);
            }
        }
        br.close();
    }
}