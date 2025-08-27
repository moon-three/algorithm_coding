import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static boolean rotateLeft;

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

            int idx = 0;
            for (int n : deque) {
                if (n == value) {
                    break;
                }
                idx++;
            }
            int half = deque.size() / 2;

            rotateLeft = idx <= half;   // 왼쪽으로 회전할지 오른쪽으로 회전할지 결정

            while (!deque.isEmpty() && deque.peekFirst() != value) {
                if (rotateLeft) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }
                count++;
            }
            deque.pollFirst();
        }
        System.out.println(count);
        br.close();
    }
}