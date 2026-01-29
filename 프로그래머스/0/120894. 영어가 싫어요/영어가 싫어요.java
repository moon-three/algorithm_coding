class Solution {
    public long solution(String numbers) {
        String[] sArr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i = 0; i < sArr.length; i++) {
            numbers = numbers.replaceAll(sArr[i], String.valueOf(i));
        }
        
        return Long.parseLong(numbers);
    }
}