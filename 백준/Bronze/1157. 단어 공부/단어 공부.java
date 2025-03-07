import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		word = word.toUpperCase();
		int[] arr = new int['Z' - 'A' + 1];
		boolean isOne = true;
		int idx = 0;
		int maxCnt = 0;
		
		for(int i = 0; i < word.length(); i++) {
			char ch =  word.charAt(i);
			arr[ch - 'A']++;
		}
		
        // 반례 abcc, maxCnt 같아도 뒤에 더 큰 maxCnt 가 있을 수도 있으니 다 돌아야 함
		for(int i = 0; i < arr.length; i++) {
			if(maxCnt > 0 && maxCnt == arr[i]) {
				isOne = false;
			}
			if(maxCnt < arr[i]) {
				isOne = true;
				maxCnt = arr[i];
				idx = i;
			}
		}
		
		if(isOne) {
			System.out.println((char)(idx + 'A'));
		} else {
			System.out.println("?");
		}
		
		br.close();
	}
}