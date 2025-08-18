import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int UND = -1;
    static final int HOUSE = 1;
    static final int ROAD = 0;
    static final int _n = 0;
    static final int _m = 1;
    static List<List<Integer>> dirs = Arrays.asList(
       Arrays.asList(-1, 0),
       Arrays.asList(1, 0),
       Arrays.asList(0, -1),
       Arrays.asList(0, 1)
    );

    static int N;   // 지도 크기
    static List<List<Integer>> graph;
    static List<List<Integer>> visited;
    static Queue<List<Integer>> queue = new LinkedList<>();

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 그래프 & visited 초기화
        graph = new ArrayList<>(Collections.nCopies(N, null));
        visited = new ArrayList<>(Collections.nCopies(N, null));

        for(int i = 0; i < N; i++) {
            graph.set(i, new ArrayList<>(Collections.nCopies(N, ROAD)));
            visited.set(i, new ArrayList<>(Collections.nCopies(N, UND)));
        }

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                int cur = Integer.parseInt(input[j]);

                graph.get(i).set(j, cur);
                visited.get(i).set(j, UND);
            }
        }

        // 그래프 순회
        for(int n = 0; n < N; n++) {
            for(int m = 0; m < N; m++) {
                // 방문하지 않았으면 함수 호출
                if(graph.get(n).get(m) == HOUSE && visited.get(n).get(m) == UND) {
                    cntHouse(n, m);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for(int n : result) {
            System.out.println(n);
        }

        br.close();
    }

    public static void cntHouse(int n, int m) {
        int cnt = 0;    // 인접한 집의 수

        queue.add(Arrays.asList(n, m));
        visited.get(n).set(m, 0);

        while(!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            cnt++;

            for(List<Integer> dir : dirs) {
                int next_n = cur.get(_n) + dir.get(_n);
                int next_m = cur.get(_m) + dir.get(_m);

                if(0 <= next_n && next_n < N &&
                        0 <= next_m && next_m < N &&
                        graph.get(next_n).get(next_m) == HOUSE &&
                        visited.get(next_n).get(next_m) == UND) {
                    queue.add(Arrays.asList(next_n, next_m));
                    visited.get(next_n).set(next_m, 0);
                }
            }
        }

        result.add(cnt);
    }

}
