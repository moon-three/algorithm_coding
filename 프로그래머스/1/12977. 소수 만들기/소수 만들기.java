class Solution {
    int rst = 0;
    public int solution(int[] nums) {
        dfs(nums, 0 ,0, 0);
        
        return rst;
    }
    
    public void dfs(int[] nums, int sum, int start, int depth) {
        if(depth == 3) {
            if(isPrime(sum)) rst++;
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            dfs(nums, sum + nums[i], i + 1, depth + 1);
        } 
    }
    
    public boolean isPrime(int sum) {
        for(int i = 2; i * i <= sum; i++) {
            if(sum % i == 0) return false;
        }
        return true;
    }
    
}