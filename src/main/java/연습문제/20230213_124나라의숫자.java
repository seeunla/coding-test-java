import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        int m = Integer.parseInt(n);
        
        StringBuilder sb = new StringBuilder();
        
        if (n % 3 == 0) {
            if ( n/3 != 3) {
                sb.append(n / 3 - 1);    
            } else {
                sb.append(n/3 +1);
            }
            
        }
        
        return answer;
    }
}
