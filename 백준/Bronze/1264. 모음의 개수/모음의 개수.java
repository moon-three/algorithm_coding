import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Character> vowels = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');

        StringBuilder sb = new StringBuilder();
        while (true) {
            String data = br.readLine();
            int cnt = 0;

            if(data.equals("#")) {
                break;
            }

            for(int i = 0; i < data.length(); i++) {
                char ch = data.charAt(i);
                if(vowels.contains(ch)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}