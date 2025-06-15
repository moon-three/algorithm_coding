import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static Stack<String> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String value = "()[]";
		
		while (true) {		
			String s = br.readLine();
			if(s.equals(".")) {
				break;
			}
			
			String[] sArr = s.split("");
			boolean isMatched = true;
			
			for(int i = 0; i < sArr.length; i++) {
				String now = sArr[i];
				if(value.contains(now)) {
					isMatched = checkMatching(now);
					if(!isMatched) {
						break;
					}
				}
			}
			
			if(stack.isEmpty() && isMatched) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");
			
			stack.clear();
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static boolean checkMatching(String s) {
		
		if(s.equals("(") || s.equals("[")) {
			stack.push(s);
		} else {
			if(stack.isEmpty()) {
				return false;
			}
			String pre = stack.peek();
			if(s.equals(")") && pre.equals("(")) {
				stack.pop();
			} else if (s.equals("]") && pre.equals("[")) {
				stack.pop();
			} else {
				return false;
			}
		}
		return true;
	}
}