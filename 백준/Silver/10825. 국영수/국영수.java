import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	
	String name; 
	int kor;
	int eng;
	int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	@Override
	public int compareTo(Student o) {
		
		if(this.kor == o.kor && this.eng == o.eng && this.math == o.math) {
			return this.name.compareTo(o.name);
		} else if(this.kor == o.kor && this.eng == o.eng) {
			return o.math - this.math; 
		} else if(this.kor == o.kor) {
			return this.eng - o.eng;
		}
		
		return o.kor - this.kor;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Student[] arr = new Student[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			arr[i] = new Student(name, kor, eng, math);
		}
		Arrays.sort(arr);
		
		for(Student st : arr) {
			System.out.println(st.name);
		}
		br.close();
	}
}