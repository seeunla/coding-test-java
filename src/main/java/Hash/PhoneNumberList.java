package Hash;

import java.util.HashSet;

public class PhoneNumberList {
    public static void main(String[] args) {
        String[] phone_book = new String[3];
        phone_book[0] = "119";
        phone_book[1] = "97674223";
        phone_book[2] = "1195524421";

        solution(phone_book);
    }
    //     public boolean solution(String[] phone_book) {
//         boolean answer = true;
    // Arrays.sort(phone_book, new Comparator<String>() {
    // 	public int compare(String s1, String s2) {
    // 		return Integer.compare(s2.length(), s1.length());
    // 	}
    // });
    // 문자열 길이를 기준으로 내림차순으로 정렬
//         Arrays.sort(phone_book, (s1, s2) -> s1.length() - s2.length());

//         for (int i =0; i <phone_book.length-1; i++) {
//             for (int j = 0; j<i; j++) {
//                 if (phone_book[j].indexOf(phone_book[i]) == 0)
//                 return false;
//             }
//         }
//         return answer;
//     }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        //Arrays.sort(phone_book, (s1, s2) -> s2.length() - s1.length());

        HashSet<String> set = new HashSet<>();

        for (String s1: phone_book) {
            set.add(s1);
        }
        //Arrays.stream(phone_book).forEach(s-> set.add(s));

        for (String s2 : set) {
            for (int i =1; i< s2.length(); i++) {
                if (set.contains(s2.substring(0,i))) {
                    return false;
                }
            }
        }

        return answer;
    }
}
