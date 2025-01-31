import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
	int idx;
	int age;
	String name;
	
	public Person(int idx, int age, String name) {
		this.idx = idx;
		this.age = age;
		this.name = name;
	}
	
	@Override
	public int compareTo(Person person) {
		if(age == person.age) {
			return Integer.compare(this.idx, person.idx);
		}
		return Integer.compare(this.age, person.age);
	}
	
	@Override
	public String toString() {
		return this.age + " " + this.name;
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Person[] arr = new Person[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Person(i, Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(arr);

		for(Person p : arr) {
			System.out.println(p);
		}
		
		br.close();
	}
}
