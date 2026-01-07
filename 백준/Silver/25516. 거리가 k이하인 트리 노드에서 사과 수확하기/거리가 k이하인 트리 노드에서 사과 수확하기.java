import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }

        int[] apples = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            apples[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();
        int result = 0;

        queue.add(new int[]{0, 0}); // 노드랑 깊이 같이 넣음
        result += apples[0];

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int depth = cur[1];

            if(depth == k) break;

            for(int next : graph[node]) {
                result += apples[next];
                queue.add(new int[]{next, depth+1});
            }
        }

        System.out.println(result);
        br.close();
    }
}
