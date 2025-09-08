import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] commands = br.readLine().split("");
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.substring(1, input.length() - 1);

            Deque<Integer> deque = new ArrayDeque<>();

            if(!input.isEmpty()) {
                String[] sArr = input.split(",");

                for(String s : sArr) {
                    deque.add(Integer.parseInt(s));
                }
            }

            f(deque, commands);
        }

        System.out.println(sb);
        br.close();

    }

    public static void f(Deque<Integer> deque, String[] commands) {
        boolean isReversed = false;

        for (String command : commands) {
            if (command.equals("R")) {
                isReversed = !isReversed;
            } else if (command.equals("D")) {
                if (deque.isEmpty()) {
                    sb.append("error").append("\n");
                    return;
                }
                if (!isReversed) deque.removeFirst();
                else deque.removeLast();
            }
        }

        sb.append("[");
        while(!deque.isEmpty()) {
            if (!isReversed) {
                sb.append(deque.pollFirst());
            } else {
                sb.append(deque.pollLast());
            }
            if(!deque.isEmpty()) sb.append(",");
        }
        sb.append("]").append("\n");
    }
}