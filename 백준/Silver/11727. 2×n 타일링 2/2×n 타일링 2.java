import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[] arr = new int[N+2];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 3;

        // n-2일 때 2*1 타일 놓는 경우, 2*2 타일 놓는 경우 2가지 가능
        for(int n = 3; n <= N; n++) {
            arr[n] = (arr[n-1] + arr[n-2] * 2) % 10007;
        }

        System.out.println(arr[N]);
        sc.close();
    }
}