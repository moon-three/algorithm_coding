import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Document {
    int index;
    int priority;

    public Document(int index, int important) {
        this.index = index;
        this.priority = important;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 문서 수
            int M = Integer.parseInt(st.nextToken());   // 큐에서 위치

            Queue<Document> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++) {
                queue.add(new Document(n, Integer.parseInt(st.nextToken())));
            }

            int cnt = 0;
            while(!queue.isEmpty()) {
                Document cur = queue.poll();

                boolean hasHigher = false;

                for(Document next : queue) {
                    if(next.priority > cur.priority) {
                        hasHigher = true;
                        queue.add(cur);
                        break;
                    }
                }

                if(!hasHigher) {        // 나보다 큰게 없고 지금 문서가 구하려는 문서일때
                    cnt++;
                    if(cur.index == M) {
                        break;
                    }
                }
            }

            System.out.println(cnt);
        }
        br.close();
    }
}
