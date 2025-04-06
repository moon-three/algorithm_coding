import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		
		// 작은 소수부터 하나씩 나눠보기 
		for(int i = 2; i * i <= N; i++) {
			while(N % i == 0) {
				bw.write(String.valueOf(i));	// 문자열로 바꿔줘야 함
				bw.newLine();
				N /= i;
			}
		}
		
		if(N > 1) {
			bw.write(String.valueOf(N));
		}
		
		bw.flush();
		sc.close();
	
	}		
}