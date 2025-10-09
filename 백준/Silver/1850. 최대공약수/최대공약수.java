import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input =  sc.nextLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);

        long result = gcd(a, b);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result; i++) {
            sb.append(1);
        }

        System.out.println(sb);
        sc.close();
    }

    static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}