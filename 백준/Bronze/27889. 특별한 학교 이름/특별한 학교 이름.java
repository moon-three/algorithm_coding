import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, String> hm = new HashMap<>();
        hm.put("NLCS", "North London Collegiate School");
        hm.put("BHA", "Branksome Hall Asia");
        hm.put("KIS", "Korea International School");
        hm.put("SJA", "St. Johnsbury Academy");

        String input = sc.nextLine();
        for(Map.Entry<String, String> entry : hm.entrySet()) {
            if(input.equals(entry.getKey())) {
                System.out.println(entry.getValue());
                break;
            }
        }
        sc.close();
    }
}