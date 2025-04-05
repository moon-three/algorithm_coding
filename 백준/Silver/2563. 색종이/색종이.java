import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[100][100];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(int j = A; j < A + 10; j++) {
				for(int k = B; k < B + 10; k++) {
					if(arr[j][k] == 1) {
						continue;
					}
					arr[j][k]++;
				}
			}
		}
		
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 1) {
					total++;
				}
			}
		}
		
		System.out.println(total);
		br.close();
		
	}
}