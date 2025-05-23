import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			String answer = "";

			int k = Integer.parseInt(br.readLine());
			
			for(int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int data = Integer.parseInt(st.nextToken());
				
				switch (command) {
				case "I":
					tm.put(data, tm.getOrDefault(data, 0) + 1);
					break;
					
				case "D":				
					if(tm.isEmpty()) {
						break;
					}
					
					Entry<Integer, Integer> e;
					if(data == 1) {
						e = tm.lastEntry();
					} else {
						e = tm.firstEntry();
					}
					
					if(e.getValue() == 1) {
						tm.remove(e.getKey());
					} else {
						tm.put(e.getKey(), e.getValue() - 1);
					}
					break;
				}	
			}		

			if(tm.isEmpty()) {
				answer = "EMPTY";
			} else {
				answer = tm.lastKey() + " " + tm.firstKey();
			}		
			System.out.println(answer);
		}
		br.close();
	}
}
