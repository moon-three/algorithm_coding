import java.util.Arrays;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        
        String s = "";
        int index = 0;
        String value = "";
                
        for(int i = 0; i < str_list.length; i++) {
        	s= str_list[i];
        	if(s.equals("r") || s.equals("l"))  {
        		index = i;
        		break;
        	}
        }
        
        if(s.equals("r")) {
        	for(int i = index + 1; i < str_list.length; i++) {
        		value += str_list[i];
        	}
        }
        if(s.equals("l")) {
        	for(int i = 0; i < index; i++) {
        		value += str_list[i];
        	}
        }
        if(s.equals("")) {
        	value = "";
        }
        
       answer = new String[value.length()];
       for(int i = 0; i < value.length(); i++) {
    	   answer[i] = value.charAt(i) + "";
       }
        
        return answer;
    }
}