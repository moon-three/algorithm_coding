import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long result = multiply(A, B);
        System.out.println(result);
        br.close();
    }

    static long multiply(long a, long b) {
        if(b==1) return a % C;

        long res = multiply(a, b/2) % C;
        long result = res * res % C;

        if(b % 2 == 0) return result;
        else return a * result % C;
    }
}