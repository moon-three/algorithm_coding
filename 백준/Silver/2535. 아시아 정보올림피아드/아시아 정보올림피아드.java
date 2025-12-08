import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    int nation;
    int num;
    int score;

    public Person(int nation, int num, int score) {
        this.nation = nation;
        this.num = num;
        this.score = score;
    }

    @Override
    public int compareTo(Person o) {
        return o.score - this.score;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Person[] people = new Person[N];
        int[] nations = new int[N+1];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            people[i] = new Person(nation, num, score);
        }

        Arrays.sort(people);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(Person p : people) {
            if(++nations[p.nation] >= 3) continue;

            sb.append(p.nation).append(" ").append(p.num).append("\n");
            cnt++;
            if(cnt == 3) break;
        }
        System.out.println(sb);
        br.close();
    }
}
