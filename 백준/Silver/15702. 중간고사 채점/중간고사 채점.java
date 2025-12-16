import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    int num = 0;
    int score = 0;

    public Person(int num, int score) {
        this.num = num;
        this.score = score;
    }

    @Override
    public int compareTo(Person o) {
        if(this.score == o.score) return this.num - o.num;
        return o.score - this.score;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] scores = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            scores[n] = Integer.parseInt(st.nextToken());
        }

        Person[] arr = new Person[M];

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int n = 0; n < N; n++) {
                String data = st.nextToken();
                if(data.equals("O")) sum += scores[n];
            }
            arr[m] = new Person(num, sum);
        }

        Arrays.sort(arr);

        System.out.println(arr[0].num + " " + arr[0].score);
        br.close();
    }
}
