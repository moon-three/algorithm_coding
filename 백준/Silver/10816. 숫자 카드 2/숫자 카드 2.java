import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashMap<Integer, Integer> hm = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			hm.put(n, hm.getOrDefault(n, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int value = hm.getOrDefault(Integer.parseInt(st.nextToken()), 0);
			sb.append(value + " ");
		}
		
		System.out.println(new String(sb).trim());
		br.close();
	}
}