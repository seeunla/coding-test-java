package routeforce;
import java.util.*;
import java.lang.Math;

public class isPrime {
    public static void main(String[] args) {
        solution("17");
    }
    static HashSet<Integer> set = new HashSet<>();

    public static boolean isPrime(int n) {
        if(n == 1 || n == 0) {
            return false;
        }

        int limit = (int)Math.sqrt(n);

        for (int i = 2; i <= limit; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void recursive(String preStr, String str) {
        System.out.printf("recursive 시작: \n" +  "preStr: "+ preStr + "str: " + str + "\n");
        if (!preStr.equals("")) {
            set.add(Integer.parseInt(preStr));
        }

        for (int i=0; i<str.length(); i++) {
            System.out.printf("for문: " + i + " " + preStr + str.charAt(i) + " " + str.substring(0,i) + str.substring(i+1) + "\n");
            recursive(preStr + str.charAt(i), str.substring(0,i) + str.substring(i+1));
        }
    }

    public static int solution(String numbers) {
        int answer = 0;

        recursive("", numbers);
        Iterator<Integer> I = set.iterator();

        while(I.hasNext()) {
            int num = I.next();
            if(isPrime(num))
                answer++;

        }
        return answer;
    }

}
