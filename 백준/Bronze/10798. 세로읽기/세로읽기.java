import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] mat = new String[5][];
		int maxLength = 0;
		
		// 초기화
		for(int i = 0; i < mat.length; i++) {
			String s = br.readLine();
			mat[i] = new String[s.length()];
			maxLength = Math.max(maxLength, s.length());
			for(int j = 0; j < mat[i].length; j++) {
				mat[i][j] = s.charAt(j) + "";
			}
		}
		
		
		for(int i = 0; i < mat.length; i++) {
			if(mat[i].length < maxLength) {
				String[] sArr = mat[i];
				mat[i] = new String[maxLength];
				for(int j = 0; j < sArr.length; j++) {
					mat[i][j] = sArr[j];
				}	
			}
		}
		
		String result = "";
		
		for(int i = 0; i < mat[0].length; i++) {
			for(int j = 0; j < mat.length; j++) {
				if(mat[j][i] == null) {
					continue;
				}
				result += mat[j][i];
			}
		}

		System.out.println(result);
		br.close();
	}
}