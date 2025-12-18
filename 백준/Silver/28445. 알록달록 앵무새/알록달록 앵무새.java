import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] colors = new String[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2; i++) {
            String color = st.nextToken();
            colors[i] = color;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 2; i < 4; i++) {
            String color = st.nextToken();
            colors[i] = color;
        }

        Set<String> combine = new HashSet<>();

        for (String string : colors) {
            for (String color : colors) {
                combine.add(string + " " + color);
            }
        }

        List<String> sortCombine = new ArrayList<>(combine);
        Collections.sort(sortCombine);

        for(String s : sortCombine) {
            System.out.println(s);
        }
        br.close();
    }
}
