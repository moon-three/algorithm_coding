
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        br.close();

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{A, 1});

        while(!queue.isEmpty()) {
            long[] cur = queue.poll();
            long value = cur[0];
            long cnt = cur[1];

            if(value == B) {
                System.out.println(cnt);
                return;
            }
            if(value > B) {
                continue;
            }
            queue.add(new long[]{value*2, cnt+1});
            queue.add(new long[]{value*10+1, cnt+1});   // 오른쪽에 1추강
        }
        System.out.println(-1);
    }
}