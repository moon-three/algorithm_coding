import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hm = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            int data = Integer.parseInt(st.nextToken());
            hm.put(data, hm.getOrDefault(data, 0) + 1);
        }

        int max = 0;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            max = Integer.max(max, entry.getValue());
        }

        System.out.println(max);
        br.close();
    }
}