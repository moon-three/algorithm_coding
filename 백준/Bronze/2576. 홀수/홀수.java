import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < 7; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input % 2 == 0) {
				continue;
			}
			else {
				if(input < min) {
					min = input;
				}
				sum += input;
			}
		}
		
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
		br.close();
	}
}