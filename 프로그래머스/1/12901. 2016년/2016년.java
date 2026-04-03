import java.time.LocalDate;

class Solution {
    public String solution(int a, int b) {
        String answer = "";

        String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        LocalDate date = LocalDate.of(2016, a, b);
        int idx = date.getDayOfWeek().getValue();

        return dayOfWeek[idx % 7];
    }
}