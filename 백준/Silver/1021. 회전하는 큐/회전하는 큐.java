import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    static int N, M;
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int n = 1; n <= N; n++) {
            deque.addLast(n);
        }

        st = new StringTokenizer(br.readLine());
        for(int m = 0; m < M; m++) {
            int value = Integer.parseInt(st.nextToken());
            // deque 에서 value 위치가 반 보다 앞이면 뒤로, 반보다 뒤면 앞으로 해야할거같은데
            int idx = 0;
            for(int n : deque) {
                if(n == value) {
                    break;
                }
                idx++;
            }

            int half = deque.size() / 2;

            if(idx <= half) {
                while(true) {
                    int cur = deque.pollFirst();
                    if(cur == value) {
                        break;
                    }
                    deque.addLast(cur);
                    count++;
                }
            } else {
                while(true) {
                    int cur = deque.pollLast();
                    if(cur == value) {
                        count++;
                        break;
                    }
                    deque.addFirst(cur);
                    count++;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}