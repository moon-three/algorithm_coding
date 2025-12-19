import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Score implements Comparable<Score> {
    String subject;
    int score;

    public Score(String subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    @Override
    public int compareTo(Score o) {
        return this.score - o.score;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Score[] arr = new Score[N];
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            arr[n] = new Score(subject, score);
        }

        int sum = 0;
        for(int k = 0; k < K; k++) {
            String data = br.readLine();
            for(Score s : arr) {
                if(s.subject.equals(data)) {
                    sum += s.score;
                    s.score = 0;
                }
            }
        }

        Arrays.sort(arr);

        int min = sum;
        int max = sum;
        for(int i = 0; i < M-K; i++) {
            min += arr[i+K].score;
            max += arr[arr.length-1-i].score;
        }
        System.out.println(min + " " + max);
        br.close();

    }
}