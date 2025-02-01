import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// map 에 대문자랑 개수 저장 -> % 3 == 0 이면 다음 글자 확인 .. ? 
		
		for(int i = 0; i < T; i++) {
			char[] cArr = br.readLine().toCharArray();
			HashMap<Character, Integer> map = new HashMap<>();
			boolean flag = true;
			
			for(int j = 0; j < cArr.length; j++) {
				map.put(cArr[j], map.getOrDefault(cArr[j], 0) + 1);
				
				if(map.get(cArr[j]) % 3 == 0) {
					if(j != cArr.length - 1 && cArr[j] == cArr[j + 1]) {	// 마지막 문자가 아니고 다음 글자가 같으면 진행
						j++;
						continue;
					} else {
						flag = false;
						break;
					}
				}
			}	
			
			if(flag) {
				System.out.println("OK");
			} else {
				System.out.println("FAKE");
			}
			
		}
		
		br.close();
	}
}
