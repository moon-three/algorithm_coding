import java.util.Scanner;

public class Main {

    static int fibCnt = 0;
    static int fibonacciCnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        fib(N);
        fibonacci(N);

        System.out.println(fibCnt + " " + fibonacciCnt);
        sc.close();

    }

    public static int fib(int n) {
        if(n == 1 || n == 2) {
            fibCnt++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibonacci(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            fibonacciCnt++;
        }
        return arr[n];
    }
}