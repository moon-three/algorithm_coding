import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String me = sc.nextLine();
        String doctor = sc.nextLine();

        me = me.substring(0, me.indexOf("h"));
        doctor = doctor.substring(0, doctor.indexOf("h"));

        if(me.length() >= doctor.length()) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
        sc.close();
    }
}