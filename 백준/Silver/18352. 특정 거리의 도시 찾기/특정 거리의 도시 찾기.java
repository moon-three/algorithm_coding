import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int UND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visited = new ArrayList<>(Collections.nCopies(N + 1, UND));

        List<Integer> result = new ArrayList<>();

        visited.set(X, 0);
        queue.add(X);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int nextNode : graph.get(cur)) {
                if(visited.get(nextNode) == UND) {
                    visited.set(nextNode, visited.get(cur) + 1);
                    queue.add(nextNode);
                }
            }
        }

        for(int i = 1; i < visited.size(); i++) {
            if(visited.get(i) == K) {
                result.add(i);
            }
        }

        if(result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for(int n : result) {
                System.out.println(n);
            }
        }

        br.close();
    }
}
