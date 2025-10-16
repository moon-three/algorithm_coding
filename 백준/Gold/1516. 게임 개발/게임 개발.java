import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] lists;
    static int[] times;
    static int[] indegree;

    static Queue<Integer> queue = new LinkedList<>();
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        times = new int[N+1];
        indegree = new int[N+1];
        lists = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[n] = time;

            while (true) {
                int data = Integer.parseInt(st.nextToken());
                if(data == -1) {
                    break;
                }
                lists[data].add(n); // list[선행].add(후행)
                indegree[n]++;  // indegree -> 이 일 하기 전에 먼저 해야하는 일이 몇개인지를 저장
            }
        }

        answer = new int[N+1];
        for(int n = 1; n <= N; n++) {
            if(indegree[n] == 0) {
                queue.add(n);
            }
        }
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : lists[cur]) {
                answer[next] = Math.max(answer[next], times[cur] + answer[cur]);    // 더 오래 걸리는 시간울 고려해야함
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for(int n = 1; n <= N; n++) {
            answer[n] += times[n];
        }

        for(int n = 1; n <= N; n++) {
            System.out.println(answer[n]);
        }
        br.close();

    }
}
