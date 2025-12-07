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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sortReverse(arr);
        int day = 1;
        for(int i = 0; i < N; i++) {
            arr[i] += day++;
        }
        int max = arr[0];
        for(int i : arr) {
            max = Math.max(max, i);
        }
        System.out.println(max+1);
        br.close();
    }

    public static void sortReverse(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}