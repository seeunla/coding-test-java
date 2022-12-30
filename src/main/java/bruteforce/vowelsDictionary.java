package bruteforce;

import java.util.Arrays;

public class vowelsDictionary {
    private static int answer;
    private static String[] alphabet = {"A", "E", "I", "O", "U"}; // 모음
    private static String[] result;


    public static void main(String[] args) {
        String s = "I";
        solution(s);
        System.out.println("answer: "+ answer);
    }

    public static int solution(String word) {
        answer = 0;
        // 주어진 문자열을 배열로 쪼개는 과정
        String[] words = word.split("");
        result = new String[word.length()];
        dfs(0, words, result);
        return answer;
    }

    public static void dfs(int depth, String[] words, String[] result) {
        //System.out.println("answer: " + answer + " words: " + words + " result: " + result);
        if (depth >= 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            // 필요한 내용만 담기위해 주어진 문자열 길이에 해당하는 만큼만 저장
            if (depth < words.length) {
                result[depth] = alphabet[i];
            }
            answer++;
            // 주어진 문자열과 일치하는지 확인
            if (depth >= words.length -1 && Arrays.equals(words, result)) {
                return;
            }
            // 재귀
            dfs(depth+1, words, result);
        }
    }

}
