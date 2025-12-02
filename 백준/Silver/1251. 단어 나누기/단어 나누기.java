import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int N = input.length();

        List<String> list = new ArrayList<>();

        for(int i = 1; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                String a = input.substring(0, i);
                String b = input.substring(i, j);
                String c = input.substring(j, N);

                list.add(reverse(a) + reverse(b) + reverse(c));
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
        sc.close();
    }

    public static String reverse(String str) {
        String[] arr = str.split("");

        for(int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return String.join("", arr);
    }
}