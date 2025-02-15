import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
 		for(int i = 0; i < N; i++) {
			String value = br.readLine();
			ArrayList<String> cur = map.get(value.length());
			if(cur == null) {
				cur = new ArrayList<>();
			}
			cur.add(value);
			map.put(value.length(), cur);
		}
 		
 		for(int key : map.keySet()) {				// 키를 하나씩 가져와서 		
 			ArrayList<String> list = map.get(key);
 			
 			list.sort((a, b) -> {
 				int sumA = getSum(a);
 				int sumB = getSum(b);
 				if(sumA != sumB) {
 					return sumA - sumB;
 				}
 				return a.compareTo(b);
 			});
 		
 			for(String s : list) {
 				System.out.println(s);
 			}	
 		}
 		br.close();
	}
	
	public static int getSum(String s) {
		int sum = 0;
		for(char ch : s.toCharArray()) {
			if(ch >= '0' && ch <= '9') {
				sum += ch - '0';
			}
		}
		return sum;
	}
}