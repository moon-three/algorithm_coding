import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String[] data = br.readLine().split(" ");
			String cmd = data[0];
			
			switch(cmd) {
			case "add":
				add(Integer.parseInt(data[1]));
				break;
			case "remove":
				remove(Integer.parseInt(data[1]));
				break;
			case "check":
				int result = check(Integer.parseInt(data[1]));
				sb.append(result).append("\n");
				break;
			case "toggle":
				toggle(Integer.parseInt(data[1]));
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void all() {
		set.clear();
		for(int i = 1; i <= 20; i++) {
			set.add(i);
		}
	}
	
	static void add(int n) {
		set.add(n);
	}
	
	static void remove(int n) {
		set.remove(n);
	}
	
	static int check(int n) {
		if(set.contains(n)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	static void toggle(int n) {
		if(set.contains(n)) {
			set.remove(n);
		} else {
			set.add(n);
		}
	}
	
	static void empty() {
		set.clear();
	}
	
}