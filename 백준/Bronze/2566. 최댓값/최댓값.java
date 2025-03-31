import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] mat = new int[9][9];
		// 값 초기화
		for(int i = 0; i < mat.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < mat[0].length; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;
		int col = 0;
		int row = 0;
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] > max) {
					max = mat[i][j];
					col = i;
					row = j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println((col + 1) + " " + (row + 1));
		br.close();
		
	}
}
