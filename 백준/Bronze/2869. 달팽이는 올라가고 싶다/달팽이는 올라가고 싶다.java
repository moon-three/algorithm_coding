import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());   // 낮
        int B = Integer.parseInt(st.nextToken());   // 밤
        int V = Integer.parseInt(st.nextToken());

        int day = 0;
        day = (V - A) / (A - B) + 1;
        if((V - A) % (A - B) != 0) {
            day += 1;
        }
        System.out.println(day);
        br.close();
    }
}