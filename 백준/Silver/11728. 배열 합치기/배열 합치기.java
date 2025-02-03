import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] A = new int[Integer.parseInt(st.nextToken())];
		int[] B = new int[Integer.parseInt(st.nextToken())];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < B.length; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int AIdx = 0;
		int BIdx = 0;
		
		while (AIdx < A.length || BIdx < B.length) {
			
			if(AIdx < A.length && BIdx < B.length) {
				if(A[AIdx] < B[BIdx]) {
					sb.append(A[AIdx++]);
				} else {
					sb.append(B[BIdx++]);
				}
			} else if (AIdx < A.length) {
				sb.append(A[AIdx++]);
			} else if (BIdx < B.length) {
				sb.append(B[BIdx++]);
			}
			sb.append(" ");
		}
		
		System.out.println(sb.toString().trim());
		
		br.close();
	}
}
