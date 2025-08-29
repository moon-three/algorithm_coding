import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static final int UND = -1;

    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int maxLength = Math.max(N, K) * 2;
        visited = new int[maxLength + 1];
        Arrays.fill(visited, UND);

        queue.add(N);
        visited[N] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : Arrays.asList(cur-1, cur+1, cur*2)) {
                if(0 <= next && next <= maxLength && visited[next] == UND) {
                    queue.add(next);
                    visited[next] = visited[cur] + 1;
                }
            }
        }

        System.out.println(visited[K]);
        br.close();
    }
}
