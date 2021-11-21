import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

    private static final StreamTokenizer st
            = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int examStrategyDp(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // dp[i][j] : 使用 j 分钟做前 i 个题目(包含第 i 个)所能够获得的最高分
        int[][] dp = new int[arr.length + 1][121];
        for (int i = 1; i <= arr.length; i++) {
            int pi = arr[i-1][0];
            int ai = arr[i-1][1];
            int qi = arr[i-1][2];
            int bi = arr[i-1][3];
            for (int j = 0; j <= 120; j++) {
                // 如果有时间做完第 i 个题目
                // 那么对于第 i 个题目而言，有 3 种策略：不做/做一部分/做完
                // 如果「不做」，拿 j 分钟去分配「前 i-1 个题目」
                // 如果「做一部分」，拿 j-pi 分钟去分配「前 i-1 个题目」，再加上本题所得分 ai
                // 如果「做完」，拿 j-qi 分钟去分配「前 i-1 个题目」，再加上本题所得分 bi
                if (j >= qi) {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - pi] + ai, dp[i - 1][j - qi] + bi));
                }
                // 如果只有时间做第 i 个题目的一部分
                else if (j >= pi) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - pi] + ai);
                }
                // 没有足够的时间去碰第 i 个题目
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][120];
    }

    public static void main(String[] args) {
        int N = nextInt();
        int[][] arr = new int[N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = nextInt();
            }
        }
        System.out.println(examStrategyDp(arr));
    }
}