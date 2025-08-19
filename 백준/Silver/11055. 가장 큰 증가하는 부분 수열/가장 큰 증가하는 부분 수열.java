import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        List<Integer> table = new ArrayList<>(Collections.nCopies(N + 1, 0));
        arr.add(0); // 0번은 사용안함

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for(int cur = 1; cur <= N; cur++) {
            int max = 0;    // cur 까지 최대 합
            for(int pre = 1; pre < cur; pre++) {
                if(arr.get(pre) < arr.get(cur) && max < table.get(pre)) {
                    max = table.get(pre);
                }
            }
            table.set(cur, max + arr.get(cur));
            result = Math.max(result, table.get(cur));
        }
        System.out.println(result);
        br.close();
    }
}
