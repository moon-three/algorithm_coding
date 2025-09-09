import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = "!" + br.readLine();
        String B = "!" + br.readLine();

        List<List<Integer>> table = new ArrayList<>(Collections.nCopies(A.length(), null));

        for(int n = 0; n < A.length(); n++) {
            table.set(n, new ArrayList<>(Collections.nCopies(B.length(), 0)));
        }

        for(int a = 1; a < A.length(); a++) {
            char charA = A.charAt(a);
            for(int b = 1; b < B.length(); b++) {
                char charB = B.charAt(b);

                if(charA == charB) {
                    table.get(a).set(b, table.get(a-1).get(b-1) + 1);
                } else {
                    table.get(a).set(b, Math.max(table.get(a).get(b-1), table.get(a-1).get(b)));
                }
            }
        }

        System.out.println(table.get(A.length()-1).get(B.length()-1));
        br.close();
    }
}
