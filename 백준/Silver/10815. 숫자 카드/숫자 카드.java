import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append(" ");
		}
		
		String result = new String(sb).trim();
		System.out.println(result);
		br.close();
	}
}