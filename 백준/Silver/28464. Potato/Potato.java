import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        if(arr.length == 1) {
            System.out.println(0 + " " + arr[0]);
            return;
        }

        Arrays.sort(arr);

        int sungwoo = 0;
        int park = 0;

        for(int i = 0; i < arr.length / 2; i++) {
            sungwoo += arr[i];
            park += arr[arr.length - 1 -i];
        }
        if(arr.length % 2 != 0) {
            park += arr[arr.length / 2];
        }
        System.out.println(sungwoo + " " + park);
    }
}
