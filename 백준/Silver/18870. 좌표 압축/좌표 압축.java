import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < sorted.size(); i++) {
            int cur = sorted.get(i);
            if(map.containsKey(cur)) {
                continue;
            }
            map.put(cur, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(map.get(n)).append(" ");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}