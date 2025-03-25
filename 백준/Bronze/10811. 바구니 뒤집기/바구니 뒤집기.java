import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	 public static void reverse(int[] arr, int i1, int i2) {
		 
		 int idx1 = i1 - 1;
		 int idx2 = i2 - 1;

		 for(int i = 0; i < (i2 - i1 + 1) / 2; i++) {
			 int tmp = arr[idx1 + i];
			 arr[idx1 + i] = arr[idx2 - i];
			 arr[idx2 - i] = tmp;	 
		 }
	
	 }
	 
	 public static void main(String[] args) throws IOException {
		 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int N = Integer.parseInt(st.nextToken());
		 int M = Integer.parseInt(st.nextToken());
		 
		 int[] arr = new int[N];
		 
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = i + 1;
		 }
		 
		 for(int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine());
			 int i1 = Integer.parseInt(st.nextToken());
			 int i2 = Integer.parseInt(st.nextToken());
			 
			 reverse(arr, i1, i2);
		 }
		 
		 String result = "";
		 
		 for(int i : arr) {
			 result += i + " ";
		 }
		 
		 System.out.println(result.trim());
		 br.close();
	 }
}									
