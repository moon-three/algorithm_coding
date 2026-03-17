import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] modes = new int[8001];
        double mean = 0;
        for(int i = 0; i < arr.length; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            mean += n;
            modes[n + 4000]++;
        }
        Arrays.sort(arr);

        int max = 0;    // 최빈값 찾음
        for(int mode : modes) {
            max = Math.max(max, mode);
        }

        boolean isFirst = false;
        int mode = 0;
        for(int i = 0; i < modes.length; i++) {
            if(modes[i] == max && isFirst) {
                mode = i - 4000;
                break;
            } else if(modes[i] == max) {
                isFirst = true;
                mode = i -4000;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(mean / N)).append("\n");
        sb.append(arr[N/2]).append("\n");
        sb.append(mode).append("\n");
        sb.append(arr[N-1]-arr[0]);


        System.out.println(sb);
        br.close();
    }
}