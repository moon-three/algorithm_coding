import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());   // 가로
        int V = Integer.parseInt(st.nextToken());   // 세로

        int T = Integer.parseInt(br.readLine());

        List<Integer> zero = new ArrayList<>(); // 가로로 자르는 점선 (세로길이)
        List<Integer> one = new ArrayList<>();  // 세로로 자르는 점선 (가로길이)

        zero.add(0);
        one.add(0);

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            if(i == 0) zero.add(Integer.parseInt(st.nextToken()));
            else one.add(Integer.parseInt(st.nextToken()));
        }

        zero.add(V);
        one.add(H);

        Collections.sort(zero);
        Collections.sort(one);

        int w = 0;
        int h = 0;
        for(int i = 1; i < zero.size(); i++) {
            int len = zero.get(i) - zero.get(i - 1);
            w = Math.max(w, len);
        }

        for(int i = 1; i < one.size(); i++) {
            int len = one.get(i) - one.get(i - 1);
            h = Math.max(h, len);
        }

        System.out.println(w * h);
        br.close();
    }
}