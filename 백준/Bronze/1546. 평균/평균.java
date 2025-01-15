import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] scores = new int[N];
		int M = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			if(scores[i] > M) M = scores[i];
		}
		
		double average = 0;
		for(int i = 0; i < N; i++) {
			average += ((double)scores[i]/M * 100);
		}
		average /= N;
		System.out.println(average);
		
		br.close();
	}
}