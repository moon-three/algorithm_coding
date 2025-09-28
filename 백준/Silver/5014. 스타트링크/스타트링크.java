import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;

    static int[] floor;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());   // 총 층수
        S = Integer.parseInt(st.nextToken());   // 시작
        G = Integer.parseInt(st.nextToken());   // 도착
        U = Integer.parseInt(st.nextToken());   // 위
        D = Integer.parseInt(st.nextToken());   // 아래

        floor = new int[F+1];    // 1층부터 시작하니까 +1
        Arrays.fill(floor, -1);

        queue.add(S);
        floor[S] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : Arrays.asList(cur + U, cur - D)) {
                if(0 < next && next <= F && floor[next] == -1) {
                    queue.add(next);
                    floor[next] = floor[cur] + 1;
                }
            }
        }

        if(floor[G] == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(floor[G]);
        }
        br.close();

    }
}