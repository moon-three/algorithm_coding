import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+2];    
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;    // N이 1인 경우 예외발생할 수 있기 때문에 배열 공간을 N+2로 잡음

        for(int n = 3; n <= N; n++) {
            arr[n] = (arr[n-1] + arr[n-2]) % 10007;
        }

        System.out.println(arr[N]);
        sc.close();
    }
}