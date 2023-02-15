import java.util.*;

class Solution {
    public String solution(int n) {
      String answer = "";
    // String으로 붙였을 시 효율성테스트 통과 못함    
      StringBuilder sb = new StringBuilder();
        
      while(n > 0){
          int rest = n % 3;
          n /= 3;
          if(rest == 0){
              rest = 4; // 3의 배수는 4로 바꿔야 한다.
              n -= 1; // 나누어 떨어질 경우 몫은 -1해야한다.
          }
          sb.insert(0, rest); // 0 인덱스에 rest를 삽입
      }
      
      return sb.toString(); // string으로 변환
  }
}
