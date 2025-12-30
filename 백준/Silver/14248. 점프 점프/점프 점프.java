import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        boolean[] visited = new boolean[N+1];
        
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int S = Integer.parseInt(br.readLine());
        queue.add(S);
        visited[S] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int jump : Arrays.asList(arr[cur], -arr[cur])) {
                int next = cur + jump;
                if(next <= 0 || N < next) continue;

                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(visited[i]) cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}