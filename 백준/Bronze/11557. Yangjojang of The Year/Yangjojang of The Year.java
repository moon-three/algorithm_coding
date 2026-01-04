import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class School implements Comparable<School> {
    String name;
    int bottle;

    public School(String name, int bottle) {
        this.name = name;
        this.bottle = bottle;
    }

    @Override
    public int compareTo(School o) {
        return o.bottle - this.bottle;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            School[] schools = new School[N];

            for(int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int bottle = Integer.parseInt(st.nextToken());
                schools[n] = new School(name, bottle);
            }

            Arrays.sort(schools);
            sb.append(schools[0].name).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}