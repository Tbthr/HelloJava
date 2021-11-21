import java.util.Arrays;

public class NewCode {

    //===================机器人到达指定位置放法数=============================
    public int walk(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return ways(N, M, P, K);
    }

    public int ways(int n, int curr, int end, int rest) {
        if (rest == 0) {
            return curr == end ? 1 : 0;
        }
        if (curr == 1) {
            return ways(n, 2, end, rest - 1);
        }
        if (curr == n) {
            return ways(n, n - 1, end, rest - 1);
        }
        return ways(n, curr + 1, end, rest - 1) + ways(n, curr - 1, end, rest - 1);
    }

    public int walkCache(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        // 由于只有两个变量：当前位置curr、剩余次数rest
        // 而且 curr: 1~N     rest: 0~K
        // 可以用二维数组存储
        int[][] cache = new int[N + 1][K + 1];
        // 初始化为-1，表示没有存结果
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        return waysCache(N, M, P, K, cache);
    }

    public int waysCache(int n, int curr, int end, int rest, int[][] cache) {
        // 如果已经计算过，直接返回
        if (cache[curr][rest] != -1) {
            return cache[curr][rest];
        }

        // 每种情况计算的结果都存入cache中
        int ans = 0;
        if (rest == 0) {
            ans = curr == end ? 1 : 0;
            cache[curr][rest] = ans;
            return ans;
        }
        if (curr == 1) {
            ans = waysCache(n, 2, end, rest - 1, cache);
            cache[curr][rest] = ans;
            return ans;
        }
        if (curr == n) {
            ans = waysCache(n, n - 1, end, rest - 1, cache);
            cache[curr][rest] = ans;
            return ans;
        }
        ans = waysCache(n, curr + 1, end, rest - 1, cache) + waysCache(n, curr - 1, end, rest - 1, cache);
        cache[curr][rest] = ans;
        return ans;
    }

    public int walkDp(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }

        int[][] dp = new int[N + 1][K + 1];
        // base case，因为Java中默认值为 0，所以其他位置不用手动赋值
        dp[P][0] = 1;

        for (int col = 1; col <= K; col++) {
            // 在位置 1 和 N 边界位置的情况
            dp[1][col] = dp[2][col - 1];
            dp[N][col] = dp[N - 1][col - 1];
            // 一般情况
            for (int row = 2; row < N; row++) {
                dp[row][col] = dp[row - 1][col - 1] + dp[row + 1][col - 1];
            }
        }
        return dp[M][K];
    }

    //==================排成一条线的纸牌博弈==============================

    public int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 要么「先手」赢，要么「后手」赢
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    // 在 arr[L...R] 中，先拿的情况下获得的最好分数
    public int f(int[] arr, int L, int R) {
        // 只有一张牌，直接拿走
        if (L == R) {
            return arr[L];
        }
        // 两种情况：「先拿走L位置的牌」和「先拿走R位置的牌」。取最大值
        return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));
    }

    // 在 arr[L...R] 中，后拿的情况下获得的最好分数
    public int s(int[] arr, int L, int R) {
        // 只有一张牌，由于是后拿，会被对手拿走，所以拿不到，返回0
        if (L == R) {
            return 0;
        }
        // 两种情况：「对手拿走L位置的牌」和「对手拿走R位置的牌」
        // 「零和博弈」==> 对手只会留给你最差的情况，所以取最小值
        return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));
    }

    public int winDp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        // 在二维数组中，我们定义「行为L，列为R」，由于L<=R，所以下半区用不到
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        // 1. L==R 情况下，初始化 f 和 s (s需要初始化为0, Java自动设置了)
        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
        }

        // 2. 一般情况
        // 遍历过程为：对角线向右上方移动，每次遍历的起点依次为 (0,1) (0,2) (0,3) ... (0, N-1)
        for (int i = 1; i < N; i++) {
            int L = 0;
            int R = i;
            // 沿对角线依次填空
            while (L < N && R < N) {
                f[L][R] = Math.max(arr[L] + s[L + 1][R], arr[R] + s[L][R - 1]);
                s[L][R] = Math.min(f[L + 1][R], f[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(f[0][N - 1], s[0][N - 1]);
    }

    //==================象棋中马的跳法==============================

    // 当前位置在(i,j)，剩余rest步，到达(a,b)的所有方法数的总和
    public int ways(int i, int j, int rest, int a, int b) {
        // 纵坐标10条线 0~9
        // 横坐标9条线 0~8
        if (i < 0 || i > 9 || j < 0 || j > 8) {
            return 0;
        }
        // 没有剩余步数了，判断当前位置在不在(a,b)
        // 如果在(a,b)，说明之前走的是一种有效的走法
        if (rest == 0) {
            return (i == a && j == b) ? 1 : 0;
        }
        // 对于一般位置而言，枚举所有的走法（越界情况会在函数开头被过滤掉）
        return ways(i - 2, j + 1, rest - 1, a, b)
                + ways(i - 1, j + 2, rest - 1, a, b)
                + ways(i + 1, j + 2, rest - 1, a, b)
                + ways(i + 2, j + 1, rest - 1, a, b)
                + ways(i + 2, j - 1, rest - 1, a, b)
                + ways(i + 1, j - 2, rest - 1, a, b)
                + ways(i - 1, j - 2, rest - 1, a, b)
                + ways(i - 2, j - 1, rest - 1, a, b);
    }

    public int waysDp(int i, int j, int rest, int a, int b) {
        int[][][] dp = new int[10][9][rest + 1];
        // 1. rest == 0
        dp[a][b][0] = 1;
        // 2. 一般情况
        // 每一层的值都依赖下一层，即 step-1 层
        for (int step = 1; step <= rest; step++) {
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 9; col++) {
                    dp[row][col][step] = getVal(dp, row - 2, col + 1, step - 1)
                            + getVal(dp, row - 1, col + 2, step - 1)
                            + getVal(dp, row + 1, col + 2, step - 1)
                            + getVal(dp, row + 2, col + 1, step - 1)
                            + getVal(dp, row + 2, col - 1, step - 1)
                            + getVal(dp, row + 1, col - 2, step - 1)
                            + getVal(dp, row - 1, col - 2, step - 1)
                            + getVal(dp, row - 2, col - 1, step - 1);
                }
            }
        }
        return dp[0][0][rest];
    }

    // 获取 dp[i][j][rest] 的值，如果越界返回0
    public int getVal(int[][][] dp, int i, int j, int rest) {
        if (i < 0 || i > 9 || j < 0 || j > 8) {
            return 0;
        }
        return dp[i][j][rest];
    }

    //=================矩阵的最小路径和=======================

    public int getMinPathSum(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return process(arr, 0, 0, arr.length - 1, arr[0].length - 1);
    }

    // 从当前位置(i,j)走到(a,b)位置的最小路径和
    public int process(int[][] arr, int i, int j, int a, int b) {
        // 如果当前位置就是终点，不需要移动，最小路径和就是终点位置的值
        if (i == a && j == b) {
            return arr[a][b];
        }
        // 如果在「最后一行」只能向右移动
        if (i == a) {
            return arr[i][j] + process(arr, i, j + 1, a, b);
        }
        // 如果在「最后一列」只能向下移动
        if (j == b) {
            return arr[i][j] + process(arr, i + 1, j, a, b);
        }
        // 取「下方」和「右方」的最小值
        return Math.min(arr[i][j] + process(arr, i + 1, j, a, b),
                arr[i][j] + process(arr, i, j + 1, a, b));
    }

    public int getMinPathSumDp(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 终点的位置
        int a = arr.length - 1;
        int b = arr[0].length - 1;
        // dp[i][j] 代表的含义是：从(i,j)到终点的最小路径和
        int[][] dp = new int[a + 1][b + 1];
        // 1. 终点位置
        dp[a][b] = arr[a][b];
        // 2. 最后一列
        for (int i = a - 1; i >= 0; i--) {
            dp[i][b] = arr[i][b] + dp[i + 1][b];
        }
        // 3. 最后一行
        for (int i = b - 1; i >= 0; i--) {
            dp[a][i] = arr[a][i] + dp[a][i + 1];
        }
        // 4. 一般情况
        // 从下往上，从右往左填入
        // 第一个位置：(a-1,b-1)
        for (int i = a - 1; i >= 0; i--) {
            for (int j = b - 1; j >= 0; j--) {
                dp[i][j] = Math.min(arr[i][j] + dp[i + 1][j], arr[i][j] + dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    //=================最小代价爬楼梯=======================

    public int climbMinCost(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        // 可以从第0阶开始，也可以从第1阶开始
        return Math.min(climb(cost, 0, cost.length),
                climb(cost, 1, cost.length));
    }

    // 从 curr 到 end 所需要的最小代价
    public int climb(int[] cost, int curr, int end) {
        // 已经到了顶层
        if (curr == end) {
            return 0;
        }
        // 在顶层的下一层，只能跳一步
        if (curr == end - 1) {
            return cost[curr] + climb(cost, curr + 1, end);
        }
        // 顶层可以是「跳1步」或「跳2步」才到达的
        return Math.min(cost[curr] + climb(cost, curr + 1, end),
                cost[curr] + climb(cost, curr + 2, end));
    }

    public int climbMinCostDp(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        // dp[i] 表示：到达第i层花费的最小代价
        // 顶层代表的是 cost.length+1 所在的层
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            // 如果当前计算的是「到达顶层」的答案，它不需要再加上「顶层所在层的代价」
            // 可以理解为 cost[0...N-1] 表示前N阶的代价，而顶层是 cost[N]==0
            int c = (i == cost.length) ? 0 : cost[i];
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + c;
        }
        // 返回到达N层花费的最小代价
        return dp[cost.length];
    }

    //=================考试策略=======================

    // arr[i][pi,ai,qi,bi]
    public int examStrategy(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return strategy(arr, 2 * 60, 0);
    }

    // 当「剩余时间为 restT」「做第 curr 个题」时，可以得到的最高分数
    public int strategy(int[][] arr, int restT, int curr) {
        // 题目做完了
        if (curr == arr.length) {
            return 0;
        }
        // 方便后续编码，定义一下
        int pi = arr[curr][0];
        int ai = arr[curr][1];
        int qi = arr[curr][2];
        int bi = arr[curr][3];
        // 当前剩余时间不足以去做这道题目
        if (restT < pi) {
            return strategy(arr, restT, curr + 1);
        }
        // 当前剩余时间只能够做这道题的一部分，可以选择「不做」或「做一部分」
        if (restT < qi) {
            return Math.max(strategy(arr, restT, curr + 1),
                    ai + strategy(arr, restT - pi, curr + 1));
        }
        // 当前剩余时间能够做完这道题，可以选择「不做」或「做一部分」或「全做」
        return Math.max(Math.max(strategy(arr, restT, curr + 1),
                        ai + strategy(arr, restT - pi, curr + 1)),
                bi + strategy(arr, restT - qi, curr + 1));
    }

    public static int examStrategyDp(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // dp[i][j] : 使用 j 分钟做前 i 个题目(包含第 i 个)所能够获得的最高分
        int[][] dp = new int[arr.length + 1][121];
        for (int i = 1; i <= arr.length; i++) {
            // arr[i] 的下标是从 0 开始的，即 arr[0] 是第 1 个题目
            int pi = arr[i - 1][0];
            int ai = arr[i - 1][1];
            int qi = arr[i - 1][2];
            int bi = arr[i - 1][3];
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
        // 花 120 分钟去做前 n 个题目
        return dp[arr.length][120];
    }

    public static void main(String[] args) {
        NewCode newCode = new NewCode();
        System.out.println("=====机器人到达指定位置放法数=====");
        System.out.println(newCode.walk(5, 2, 3, 3));
        System.out.println(newCode.walkCache(5, 2, 3, 3));
        System.out.println(newCode.walkDp(5, 2, 3, 3));
        System.out.println("=====排成一条线的纸牌博弈=====");
        System.out.println(newCode.win(new int[]{1, 2, 100, 4}));
        System.out.println(newCode.winDp(new int[]{1, 2, 100, 4}));
        System.out.println("=====象棋中马的跳法=====");
        System.out.println(newCode.ways(0, 0, 10, 7, 7));
        System.out.println(newCode.waysDp(0, 0, 10, 7, 7));
        System.out.println("=====矩阵的最小路径和=====");
        System.out.println(newCode.getMinPathSum(new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}}));
        System.out.println(newCode.getMinPathSumDp(new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}}));
        System.out.println("=====最小代价爬楼梯=====");
        System.out.println(newCode.climbMinCost(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(newCode.climbMinCostDp(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println("=====考试策略=====");
        System.out.println(newCode.examStrategy(new int[][]{{20, 20, 100, 60}, {50, 30, 80, 55}, {100, 60, 110, 88}, {5, 3, 10, 6}}));
    }
}
