class Solution {
    public String solution(String polynomial) {
        int xsum = 0;
        int sum = 0;
        
        for(String s : polynomial.split(" ")) {
            if(s.equals("+")) continue;
            if(s.contains("x")) {
                String temp = s.replace("x", "");
                if(temp.equals("")) xsum += 1;
                else xsum += Integer.parseInt(temp);
            } else {
                sum += Integer.parseInt(s);
            }
        }
        
        if(xsum == 0) return sum + "";
        if(sum == 0) return xsum == 1 ? "x" : xsum + "x";

        return xsum == 1 ? "x + " + sum : xsum + "x + " + sum;
    }
}