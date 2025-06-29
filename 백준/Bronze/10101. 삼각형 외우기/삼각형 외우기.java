import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		
		for(int i = 0; i < 3; i++) {
			int data = Integer.parseInt(br.readLine());
			arr[i] = data;
		}
		
		
		if(arr[0] == 60 && arr[1] == 60 && arr[2] == 60) {
			System.out.println("Equilateral");
		} else if(arr[0] + arr[1] + arr[2] == 180) {
			Set<Integer> set = new HashSet<Integer>();
			for(int n : arr) {
				set.add(n);
			}
			if(set.size() == 2) {
				System.out.println("Isosceles");
			} else if (set.size() == 3) {
				System.out.println("Scalene");
			}
		} else {
			System.out.println("Error");
		}

		br.close();
	}
}