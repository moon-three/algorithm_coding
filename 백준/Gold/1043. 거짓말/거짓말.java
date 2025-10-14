import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;   // 사람 수
    static int M;   // 파티 수
    static int P;   // 아는 사람 수
    static int[] trueP; // 아는  사람들
    static List<Integer>[] party;   // 파티
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람들 입력받기
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        if(P == 0) {    // 진실을 아는 사람이 없으면 종료
            System.out.println(M);
            return;
        }
        trueP = new int[P+1];
        for(int i = 1; i <= P; i++) {
            trueP[i] = Integer.parseInt(st.nextToken());
        }

        // 파티 구성원 입력받기
        party = new ArrayList[M+1];
        for(int m = 1; m <= M; m++) {
            party[m] = new ArrayList<>();
        }

        for(int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int i = 0; i < cnt; i++) {
                party[m].add(Integer.parseInt(st.nextToken()));
            }
        }

        parent = new int[N+1];
        for(int n = 1; n <= N; n++) {
            parent[n] = n;
        }

        // 파티 사람들 한 집합으로 만들기
        for(int i = 1; i <= M; i++) {
            int cur = party[i].get(0);  // 0번째를 기준으로 union
            for(int j = 1; j < party[i].size(); j++) {
                union(cur, party[i].get(j));
            }
        }

        // 진실 아는 사람들인지 확인
        int result = 0;
        for(int i = 1; i <= M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for(int j = 0; j < trueP.length; j++) {
                if(find(cur) == find(trueP[j])) {
                    isPossible = false;
                }
            }
            if(isPossible) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    static int find(int a) {
        if(parent[a] != a) {
            return parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

}