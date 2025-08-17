import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(Collections.nCopies(N + 1, Integer.MAX_VALUE));

        list.set(1, 0);

        for(int n = 1; n <= N; n++) {
            for(int next : Arrays.asList(n * 2, n * 3, n + 1)) {
                if(next <= N) {
                    int min = Math.min(list.get(next), list.get(n) + 1);
                    list.set(next, min);
                }
            }
        }

        System.out.println(list.get(N));
        br.close();
    }
}
