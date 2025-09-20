import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();
        for(int n = 0; n < N; n++) {
            String data = br.readLine();
            if(data.length() < M) {
                continue;
            }
            hm.put(data, hm.getOrDefault(data, 0) + 1);
        }

        List<String> list = new ArrayList<>(hm.keySet());

        list.sort((a, b) -> {
            int aValue = hm.get(a);
            int bValue = hm.get(b);

            if (aValue != bValue) return bValue - aValue;
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}