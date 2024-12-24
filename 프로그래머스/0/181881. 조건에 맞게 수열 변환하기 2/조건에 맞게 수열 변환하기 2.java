import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
    	int answer = 0;

		while (true) {
			int[] copy = new int[arr.length];		// 비교를 하기 위한 배열
			
			for (int i = 0; i < arr.length; i++) {
				copy[i] = arr[i];					// 미리 값을 저장
				if (arr[i] >= 50 && arr[i] % 2 == 0) 		arr[i] /= 2;	
				else if (arr[i] < 50 && arr[i] % 2 != 0)	arr[i] = arr[i] * 2 + 1;
			}		
			answer += 1;
			
//			System.out.println("copy : " + Arrays.toString(copy));
//			System.out.println("arr : " + Arrays.toString(arr));
			
			if(Arrays.equals(copy, arr)) {	// 이전 배열과 같으면 반복문 종료 (비교 시 Arrays.equals() 사용)
				answer -= 1;	// 1 감소 후
				break; 		    // 종료
			}
		}     
      return answer;
    }
}