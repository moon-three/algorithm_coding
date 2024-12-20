import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
   
        List<Integer> index = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == 2) {
        		index.add(i);
        	}
        }
     	
        List<Integer> answerList = new ArrayList<>();
        
        if(index.size() == 0) answerList.add(-1);
        else {
        	for(int i = index.get(0); i <= index.get(index.size() - 1); i++) {
        		answerList.add(arr[i]);
        	}
        }

        int[] answer = new int[answerList.size()];

        for(int i = 0; i < answerList.size(); i ++) {
        	answer[i] = answerList.get(i);
        }

        return answer;
    }
}