import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Score implements Comparable<Score> {
    int solved = 0;
    int penalty = 0;

    public Score(int solved, int penalty) {
        this.solved = solved;
        this.penalty = penalty;
    }

    @Override
    public int compareTo(Score o) {
        if(o.solved == this.solved) {
            return this.penalty - o.penalty;
        }
        return o.solved - this.solved;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Score[] arr = new Score[N];

        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[n] = new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        int standard = arr[4].solved;

        int cnt = 0;
        for(int i = 5; i < arr.length; i++) {
            if(arr[i].solved < standard) break;
            cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}
