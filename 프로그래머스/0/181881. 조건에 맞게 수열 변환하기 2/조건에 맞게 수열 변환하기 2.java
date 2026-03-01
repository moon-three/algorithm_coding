import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
    	int answer = 0;

		while (true) {
			int[] copy = new int[arr.length];
			
			for (int i = 0; i < arr.length; i++) {
				copy[i] = arr[i];
				if (arr[i] >= 50 && arr[i] % 2 == 0) 		arr[i] /= 2;	
				else if (arr[i] < 50 && arr[i] % 2 != 0)	arr[i] = arr[i] * 2 + 1;
			}		
			answer += 1;

			if(Arrays.equals(copy, arr)) {
				answer -= 1;
				break;
			}
		}     
      return answer;
    }
}