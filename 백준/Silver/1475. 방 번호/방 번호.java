import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[10];

        while(N > 0) {
            arr[N % 10]++;
            N /= 10;
        }

        int max = 0;
        int sixOrNine = (arr[6] + arr[9]) % 2 == 0 ? (arr[6] + arr[9]) / 2 : (arr[6] + arr[9]) / 2 + 1;

        for(int i = 0; i < 10; i++) {
            if(i == 6 || i == 9) continue;
            max = Math.max(max, arr[i]);
        }

        max = Math.max(max, sixOrNine);

        System.out.println(max);
        sc.close();
    }
}