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
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = String.valueOf(Integer.parseInt(st.nextToken()));
			String B = String.valueOf(Integer.parseInt(st.nextToken()));
			bw.write("Case #");
			bw.write(String.valueOf(i + 1));
			bw.write(": ");
			bw.write(A + " + " + B + " = " + String.valueOf(Integer.parseInt(A) + Integer.parseInt(B)));
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
