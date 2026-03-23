import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for(int n = 0; n < N; n++) {
                String[] sArr = br.readLine().split(" ");
                map.put(sArr[1], map.getOrDefault(sArr[1], 1) + 1);
            }
            int result = 1;
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                result *= entry.getValue();
            }
            System.out.println(result - 1);
        }
    }
}