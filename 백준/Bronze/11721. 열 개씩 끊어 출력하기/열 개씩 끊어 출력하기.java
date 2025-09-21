import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split("");

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            cnt++;
            if(cnt % 10 == 0 || i == data.length - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
        sc.close();
    }
}