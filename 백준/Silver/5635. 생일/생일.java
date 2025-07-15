import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    String name;
    int year;
    int month;
    int day;

    @Override
    public int compareTo(Person o) {
        if(this.year != o.year) {
            return o.year - this.year;
        }
        if(this.month != o.month) {
            return o.month - this.month;
        }
        return o.day - this.day;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Person[] arr = new Person[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            Person person = new Person();
            person.name = st.nextToken();
            person.day = Integer.parseInt(st.nextToken());
            person.month = Integer.parseInt(st.nextToken());
            person.year = Integer.parseInt(st.nextToken());

            arr[i] = person;
        }

        Arrays.sort(arr);

        System.out.println(arr[0].name);
        System.out.println(arr[n - 1].name);
        br.close();

    }
}