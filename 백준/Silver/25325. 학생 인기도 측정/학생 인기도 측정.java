import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            String name = st.nextToken();
            map.put(name, 0);
        }

        for(int n = 0; n < N; n++) {
            String input = br.readLine();
            String[] names = input.split(" ");
            for(String name : names) {
                map.put(name, map.get(name) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if(a.getValue().equals(b.getValue()))
                return a.getKey().compareTo(b.getKey());
            return b.getValue() - a.getValue();
        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}