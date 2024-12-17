class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
  
        // 전부 띄어쓰기로 변환 후 띄어쓰기를 while 문으로 한칸으로 바꿈 그리고 split 
        // 만약 내용이 없다면 empty 출력
        
        String tmp = "abc";
        
        for(int i = 0; i < tmp.length(); i++) {
        	if(myStr.contains(tmp.charAt(i) + "")) {
        		myStr = myStr.replace(tmp.charAt(i) + "", " ");
        	}
        }
        
        while(true) {
        	if(myStr.contains("  "))	myStr = myStr.replace("  ", " ");
        	else {
        		myStr = myStr.trim();
        		break;        		
        	}
        }

        if(myStr.equals("")) myStr = "EMPTY";
        answer = myStr.split(" ");

        return answer;
    }
}