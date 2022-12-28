package bruteforce;

public class fatigue {
    public static void main(String[] args) {
        int[][] dungenons = new int[3][2];
        dungenons[0][0] = 80;
        dungenons[0][1] = 20;
        dungenons[1][0] = 50;
        dungenons[1][1] = 40;
        dungenons[2][0] = 30;
        dungenons[2][1] = 10;

        int k = 80;

        System.out.println("result: " +solution(k, dungenons));
    }

//    Set<Integer> set = new HashSet<>();
//    public int solution(int k, int[][] dungeons) {
//        perm(0, dungeons);
//        return max;
//    }
//
//    public boolean checkFatigue(int k, int mink) {
//        if (k <= 0) return false;
//        if (mink > k) return false;
//        return true;
//    }
//
//    public void perm(int k, int[][] dungeons) {
//        int count =0;
//        if (count > 0) {
//            set.add(count);
//        }
//        for (int i=0; i < dungeons.length; i++) {
//            System.out.printf(i + "\n" + + k + "\n");
//            if (checkFatigue(k, dungeons[i][0])) {
//                k = k - dungeons[i][1];
//                count++;
//                perm(k, dungeons[i+1]);
//            }
//        }
//    }

    private static int answer;
    private static boolean visited[];
    public static int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons, 0);
        return answer;
    }


    public static void dfs(int depth, int k, int[][] dungeons, int ans) {
        //System.out.println("ans :" + ans);
        //System.out.println("answer :" + answer);
        if (depth >= dungeons.length) {
            if (ans > answer) {
                answer = ans;
            }
        }

        for (int i = 0; i < dungeons.length; i++) {
            //System.out.println("i :" + i);
            //System.out.println("depth: " + depth);
            //System.out.println("k :" + k);
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (k >= dungeons[i][0]) {
                dfs(depth + 1, k - dungeons[i][1], dungeons, ans + 1);
            } else {
                dfs(depth + 1, k, dungeons, ans);
            }
            visited[i] = false;
        }
    }
}
