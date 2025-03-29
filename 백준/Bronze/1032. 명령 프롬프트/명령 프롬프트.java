import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		String result = "";
			
		if(N == 1) {
			System.out.println(S);
			return;
		}
		
		String[] example = S.split("");
		
		for(int i = 0; i < N - 1; i++) {
			String cur = br.readLine();
			for(int j = 0; j < cur.length(); j++) {
				if(!example[j].equals(cur.charAt(j) + "")) {
					example[j] = "?";
				}
			}
		}
		
		for(String s : example) {
			result += s;
		}
		System.out.println(result);
		br.close();
		
	}
}