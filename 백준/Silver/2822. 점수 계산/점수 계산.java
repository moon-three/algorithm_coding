import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Score implements Comparable<Score> {
    int idx;
    int score;

    public Score(int idx, int score) {
        this.idx = idx;
        this.score = score;
    }

    @Override
    public int compareTo(Score o) {
        return this.score - o.score;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

        Score[] scores = new Score[8];

        for(int i = 0; i < 8; i++) {
            Score score = new Score(i, Integer.parseInt(br.readLine()));
            scores[i] = score;
        }

        Arrays.sort(scores);

        int sum = 0;
        int[] idxs = new int[5];
        for(int i = 3; i < 8; i++) {
            sum += scores[i].score;
            idxs[i - 3] = scores[i].idx + 1;
        }

        Arrays.sort(idxs);

        System.out.println(sum);
        for(int i = 0; i < 5; i++) {
            System.out.print(idxs[i] + " ");
        }
        br.close();

    }
}