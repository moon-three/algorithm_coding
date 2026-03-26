import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sArr = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String input = sc.nextLine();
        for(int i = 0; i < sArr.length; i++) {
            input = input.replaceAll(sArr[i], "1");
        }
        System.out.println(input.length());

    }
}