class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        int[] nums = new int[10];
        
        for(int n : numbers) {
            nums[n]++;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                answer += i;
            }
        }
        
        return answer;
    }
}