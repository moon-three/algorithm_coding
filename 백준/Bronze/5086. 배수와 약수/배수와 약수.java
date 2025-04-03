import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			String result = "neither";
			
			if(A == 0 && B == 0) {
				break;
			}
			
			if(A < B) {
				if(B % A == 0) {
					result = "factor";
				} 
			} else {
				if(A % B == 0) {
					result = "multiple";
				}
			}
			
			bw.write(result);
			bw.newLine();
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}
