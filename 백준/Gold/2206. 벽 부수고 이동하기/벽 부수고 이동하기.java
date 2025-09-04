import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int n;
    int m;
    int breakWall;

    public Node(int n, int m, int breakWall) {
        this.n = n;
        this.m = m;
        this.breakWall = breakWall;
    }
}

public class Main {
    static final int ROAD = 0;
    static final int WALL = 1;
    static final int _n = 0;
    static final int _m = 1;
    static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] dist;            // 경로 저장
    static Queue<Node> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for(int n = 1; n <= N; n++) {
            String input = br.readLine();
            for(int m = 1; m <= M; m++) {
                map[n][m] = input.charAt(m - 1) - '0';
            }
        }

        visited = new boolean[N+1][M+1][2];     // 벽 안부순 경우, 벽 부순 경우
        dist = new int[N+1][M+1];

        System.out.println(bfs());
        br.close();
    }

    public static int bfs() {
        queue.add(new Node(1, 1,0));
        visited[1][1][0] = true;
        dist[1][1] = 1;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int n = cur.n;
            int m = cur.m;
            int broken = cur.breakWall;

            if(n == N && m == M) {
                return dist[N][M];
            }

            for(int[] dir : dirs) {
                int next_n = n + dir[_n];
                int next_m = m + dir[_m];

                if(0 < next_n && next_n <= N && 0 < next_m && next_m <= M) {
                    if(map[next_n][next_m] == ROAD && !visited[next_n][next_m][broken]) {
                        visited[next_n][next_m][broken] = true;
                        dist[next_n][next_m] = dist[n][m] + 1;
                        queue.add(new Node(next_n, next_m, broken));
                    } else if(map[next_n][next_m] == WALL && broken == 0) {
                        visited[next_n][next_m][1] = true;
                        dist[next_n][next_m] = dist[n][m] + 1;
                        queue.add(new Node(next_n, next_m, 1));
                    }
                }
            }
        }

        return -1;
    }
}