import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int cnt = 0;
            int num = Integer.parseInt(br.readLine());
            while (num != 6174) {
                int[] arr = f(num);
                num = arr[1] - arr[0];
                cnt++;
            }
            System.out.println(cnt);
        }

        br.close();
    }

    public static int[] f(int num) {
        int[] result = new int[2];
        String s = String.format("%04d", num);
        String[] sArr = s.split("");
        Arrays.sort(sArr);

        StringBuilder min = new StringBuilder();
        StringBuilder max = new StringBuilder();
        for(int i = 0; i < sArr.length; i++) {
            min.append(sArr[i]);
            max.append(sArr[sArr.length-1-i]);
        }
        result[0] = Integer.parseInt(min.toString());
        result[1] = Integer.parseInt(max.toString());

        return result;
    }
}