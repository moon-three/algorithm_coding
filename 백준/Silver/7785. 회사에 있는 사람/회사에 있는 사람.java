import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, String> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String state = st.nextToken();
			
			hm.put(name, state);
		}
		
		List<String> list = new ArrayList<>();
		
		for(Entry<String, String> entry : hm.entrySet()) {
			if(!entry.getValue().equals("leave")) {
				list.add(entry.getKey());
			}
		}
		
		list.sort((a, b) -> b.compareTo(a));
		
		for(String s : list) {
			bw.append(s + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
