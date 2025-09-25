import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                break;
            }

            int cnt = 0;
            for(int i = input + 1; i <= 2 * input; i++) {
                boolean isPrime = true;
                for(int j = 2; j * j <= i; j++) {
                    if(i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}