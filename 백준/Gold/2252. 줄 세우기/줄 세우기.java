import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] lists;
    static int[] indegree;

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드
        M = Integer.parseInt(st.nextToken()); // 간선

        lists = new ArrayList[N+1];
        for(int n = 1; n <= N; n++) {
            lists[n] = new ArrayList<>();
        }

        indegree = new int[N+1];

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            lists[A].add(B);
            indegree[B]++;
        }

        // 진입차수가 0이면 queue.add
        for(int n = 1; n <= N; n++) {
            if(indegree[n] == 0) {
                queue.add(n);
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : lists[cur]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }

            System.out.print(cur + " ");
        }
        br.close();
    }
}