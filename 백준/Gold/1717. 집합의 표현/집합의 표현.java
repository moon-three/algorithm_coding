import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int UNION = 0;
    static final int FIND = 1;

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());   // 연산 개수

        parent = new int[N+1];
        // 자기 자신으로 초기화
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op == UNION) {
                union(a, b);
            } else if(op == FIND) {
                boolean result = checkSame(a, b);
                if(result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        br.close();
    }

    public static int find(int a) {
        if(parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    public static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) {
            return true;
        }
        return false;
    }

}