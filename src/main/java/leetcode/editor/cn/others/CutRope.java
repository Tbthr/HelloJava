package leetcode.editor.cn.others;

class CutRope {
    public static void main(String[] args) {
        CutRope cutRope = new CutRope();
        System.out.println(cutRope.cuttingRope(127));
    }

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long res = quickPow(3L, n / 3 - 1, p);
        // System.out.println("res = " + res);
        if (b == 0) return (int) (res * 3 % p);
        if (b == 1) return (int) (res * 4 % p);
        return (int) (res * 6 % p);
    }

    public long quickPow(long x, int a, int p) {
        long res = 1;
        while (a > 0) {
            if ((a & 1) == 1) { // a % 2 == 1
                res = (res * x) % p;
            }
            x = (x * x) % p;
            a >>= 1; // a /= 2
        }
        return res;
    }
}