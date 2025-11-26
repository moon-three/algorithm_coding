import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Member {
    int problem;
    int year;
    String name;

    public Member(int problem, int year, String name) {
        this.problem = problem;
        this.year = year;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Member[] members = new Member[3];

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problem = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken()) % 100;
            String name = st.nextToken();
            members[i] = new Member(problem, year, name);
        }

        Arrays.sort(members, (a, b) -> a.year - b.year);
        for(int i = 0; i < 3; i++) {
            System.out.print(members[i].year);
        }

        System.out.println();

        Arrays.sort(members, (a, b) -> b.problem - a.problem);
        for(int i = 0; i < 3; i++) {
            System.out.print(members[i].name.charAt(0));
        }
        br.close();
    }
}
