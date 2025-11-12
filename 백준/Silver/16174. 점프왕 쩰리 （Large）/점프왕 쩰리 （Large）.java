import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] game;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        game = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N+1][N+1];

        bfs();

        System.out.println(visited[N][N] ? "HaruHaru" : "Hing");
        br.close();
    }

    static void bfs() {
        queue.add(new int[]{1, 1});
        visited[1][1] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int jump = game[x][y];

            if(jump == -1) return; // -1이면 도착지점 -> 성공
            if(jump == 0) continue; // 못 뛰면 더 이상 진행 X

            int down = x + jump;
            if(down <= N && !visited[down][y]) {
                queue.add(new int[]{down, y});
                visited[down][y] = true;
            }

            int right = y + jump;
            if(right <= N && !visited[x][right]) {
                queue.add(new int[]{x, right});
                visited[x][right] = true;
            }
        }
    }
}
