import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int COLOR_SIZE = 3;
    static final int INF = 987654321;

    static int N;
    static List<List<Integer>> table;
    static List<List<Integer>> colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        table = new ArrayList<>(Collections.nCopies(N+1, null));
        for(int  n = 0; n <= N; n++) {
            table.set(n, new ArrayList<>(Collections.nCopies(COLOR_SIZE, INF)));
        }
        table.set(0, Arrays.asList(0,0,0));

        colors = new ArrayList<>();
        colors.add(Arrays.asList(0,0,0));

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            colors.add(Arrays.asList(r, g, b));
        }

        for(int n = 1; n <= N; n++) {
            for(int cur = 0; cur < COLOR_SIZE; cur++) {
                for(int pre = 0; pre < COLOR_SIZE; pre++) {
                    if(cur != pre) {
                        table.get(n).set(cur, Math.min(
                                table.get(n).get(cur),
                                table.get(n-1).get(pre) + colors.get(n).get(cur)
                        ));
                    }
                }
            }
        }

        int result = INF;
        for(int color = 0; color < COLOR_SIZE; color++) {
            result = Math.min(result, table.get(N).get(color));
        }
        System.out.println(result);
        br.close();
    }
}