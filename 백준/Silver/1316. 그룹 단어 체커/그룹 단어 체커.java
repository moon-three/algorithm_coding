import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for(int n = 0; n < N; n++) {
            String input = br.readLine();
            boolean isRight = true;
            Set<Character> set = new HashSet<>();
            char prev = 0;
            for(int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if(ch == prev) continue;
                if(set.contains(ch)) {
                    isRight = false;
                    break;
                }
                prev = ch;
                set.add(prev);
            }
            if(isRight) result++;
        }
        System.out.println(result);
        br.close();
    }
}
