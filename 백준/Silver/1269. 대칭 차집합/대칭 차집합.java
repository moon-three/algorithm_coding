import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int aSize = Integer.parseInt(st.nextToken());
		int bSize = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < aSize; i++) {
			int num = Integer.parseInt(st.nextToken());
			hm.put(num, 1);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < bSize; i++) {
			int num = Integer.parseInt(st.nextToken());
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		
		for(Entry<Integer, Integer> entry : hm.entrySet()) {
			if(entry.getValue() == 1) {
				result++;
			}
		}
		
		System.out.println(result);
		br.close();
	}
}