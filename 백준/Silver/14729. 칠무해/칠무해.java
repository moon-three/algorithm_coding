import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            double score = Double.parseDouble(br.readLine());
            if(pq.size() < 7) {
                pq.offer(score);
            } else if(score < pq.peek()){
                pq.poll();
                pq.offer(score);
            }
        }

        double[] result = new double[7];
        for(int i = 6; i >= 0; i--) {
            result[i] = pq.poll();
        }

        for(double d : result) {
            System.out.printf("%.3f\n", d);
        }
        br.close();
    }
}