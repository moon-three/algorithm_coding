import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> numToName = new HashMap<>();
		HashMap<String, Integer> nameToNum = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			String name = br.readLine();
			numToName.put(i, name);
			nameToNum.put(name, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String data = br.readLine();
			if(Character.isDigit(data.charAt(0))) {
				sb.append(numToName.get(Integer.parseInt(data)));
			} else {
				sb.append(nameToNum.get(data));
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
