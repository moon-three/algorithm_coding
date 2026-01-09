class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        String s = "";
            
        for(int i = 0; i < arr.length; i++) {
            int count = 0;
            for(int j = 0; j < delete_list.length; j++) {
                if(arr[i] != delete_list[j]) count++;
            }
            if(count == delete_list.length) {
                s += String.valueOf(arr[i]) + " ";
            }
         }
        String[] tmp = s.split(" ");
        int[] answer = new int[tmp.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(tmp[i]);
        }
        return answer;
    }
}