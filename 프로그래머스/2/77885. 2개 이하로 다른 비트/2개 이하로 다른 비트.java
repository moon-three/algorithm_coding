class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
  
        for(int i = 0; i < numbers.length; i++) {
            
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String binary = Long.toBinaryString(numbers[i]);
                int idx = binary.lastIndexOf('0');

                int n = binary.length() - (idx + 1);
   
                double plus = Math.pow(2, n -1);
                answer[i] = numbers[i] + (long) plus;
            }
            
            
        }
        
        return answer;
    }
}