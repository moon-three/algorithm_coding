import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> hm = new TreeMap<>();

        for(int n = 0; n < N; n++) {
            String data = br.readLine();
            hm.put(data, hm.getOrDefault(data, 0) + 1);
        }

        int max = 0;
        String result = "";
        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
            int value = entry.getValue();
            if(value > max) {
                max = value;
                result = entry.getKey();
            }
        }

        System.out.println(result);
        br.close();
    }
}
