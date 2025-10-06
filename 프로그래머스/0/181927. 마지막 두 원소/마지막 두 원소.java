class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        int lastIndex = num_list.length - 1;
        boolean flag = num_list[lastIndex] - num_list[lastIndex - 1] > 0;
        int newNum =  flag ? num_list[lastIndex] - num_list[lastIndex -1] : num_list[lastIndex] * 2;
        
        for(int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
        answer[num_list.length] = newNum;
        
        return answer;
    }
}