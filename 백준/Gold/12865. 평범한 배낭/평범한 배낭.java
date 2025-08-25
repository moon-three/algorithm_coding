import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Item {
    int v, w;

    public Item(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Main {
    static int N;
    static int K;

    static List<Item> items;
    static List<List<Integer>> table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        items = new ArrayList<>();
        items.add(null);

        table = new ArrayList<>(Collections.nCopies(N+1, null));
        for(int i = 0; i <= N; i++) {
            table.set(i, new ArrayList<>(Collections.nCopies(K+1, 0)));
        }

        for(int n = 1; n <= N; n++) {
            st= new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items.add(new Item(v, w));
        }

        for(int n = 1; n <= N; n++) {
            for(int k = 1; k <= K; k++) {
                if(items.get(n).w > k) {
                    table.get(n).set(k, table.get(n-1).get(k));
                } else {
                    table.get(n).set(k, Math.max(
                            items.get(n).v + table.get(n-1).get(k - items.get(n).w),
                            table.get(n-1).get(k)));
                }
            }
        }

        System.out.println(table.get(N).get(K));
        br.close();
    }
}
