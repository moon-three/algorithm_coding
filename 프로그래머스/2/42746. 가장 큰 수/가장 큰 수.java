import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] sArr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            sArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(sArr, (a, b) -> (b + a).compareTo(a + b));

        if(sArr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : sArr) {
            sb.append(s);
        }

        answer = sb.toString();

        return answer;
    }
}