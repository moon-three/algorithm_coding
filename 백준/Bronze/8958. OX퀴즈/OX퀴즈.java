import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int score = 0;
		
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			sum = 0;
			score = 0;
			for(int j = 0; j < data.length(); j++) {
				char ch = data.charAt(j);
				if(ch == 'O') {
					score++;
				} else {
					score = 0;
				}
				sum += score;
			}
			System.out.println(sum);
		}
		br.close();
	}
}
