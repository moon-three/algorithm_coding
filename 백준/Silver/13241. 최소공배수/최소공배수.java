import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        long A = Long.parseLong(input.split(" ")[0]);
        long B = Long.parseLong(input.split(" ")[1]);

        // 유클리드 호제법 : 두 수의 곱 / 최대공약수
        // 오버플로우 방지를 위해 나누기 먼저
        System.out.println(A / gcd(A, B) * B);
    }

    public static long gcd(long a, long b) {
      while (b != 0) {
          long r = a % b;
          a = b;
          b = r;
      }
      return a;
    }

}