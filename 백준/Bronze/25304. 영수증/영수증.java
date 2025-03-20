import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalPrice = Integer.parseInt(br.readLine());
		int totalCnt = Integer.parseInt(br.readLine());
		
		int cal = 0;
		
		for(int i = 0; i < totalCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			cal += price * cnt;
		}
		
		if(totalPrice == cal) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		br.close();
	}
}