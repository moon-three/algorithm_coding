import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] table;
    static int[] route;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 도시 수
        int M = Integer.parseInt(br.readLine());    // 여행 계획에 속한 도시 수

        // 도시 연결 정보
        table = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 여행 루트
        route = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int m = 1; m <= M; m++) {
            route[m] = Integer.parseInt(st.nextToken());
        }

        // parent 초기화
        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 도시가 연결되어있으면 같은 집합으로 묶음
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(table[i][j] == 1) {
                    union(i , j);
                }
            }
        }

        // 여행 계획 도시들이 연결되어 있는지 확인
        boolean isConnected = true;
        int p = find(route[1]);
        for(int m = 2; m <= M ;m++) {
            if(find(route[m]) != p) {
                isConnected = false;
                break;
            }
        }

        if(isConnected) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        br.close();
    }

    public static int find(int a) {
        if(parent[a] != a) {
            return parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }
}