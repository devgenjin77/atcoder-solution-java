/*
 * ユニークビジョンプログラミングコンテスト2022 冬
 * （AtCoder Beginner Contest 283）
 * F - Permutation Distance
 * https://atcoder.jp/contests/abc283/tasks/abc283_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc283/submissions/37605437
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc283.abc283_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static final int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_p = new StringTokenizer(br.readLine());
    final int[] array_p = new int[n];
    for (int i = 0; i < n; i++) {
      array_p[i] = Integer.parseInt(st_p.nextToken()) - 1;
    }
    br.close();

    final int[][] array_p2 = new int[2][n];
    for (int i = 0; i < n; i++) {
      //pの大小関係を反転
      array_p2[0][i] = array_p[i];
      array_p2[1][i] = n - array_p2[0][i] - 1;
    }

    final int[] ans = new int[n];
    Arrays.fill(ans, 2 * n);
    for (int j = 0; j < 2; j++) {
      for (int k = 0; k < 2; k++) {
        SegTree<Integer> segTree = new SegTree<>(n, Integer::max, -INF);
        for (int i = 0; i < n; i++) {
          int x = i + array_p2[k][i];
          ans[i] = Math.min(x - segTree.prod(0, array_p2[k][i]), ans[i]);
          segTree.set(array_p2[k][i], x);
        }
      }
      int[] ans_clone = ans.clone();
      for (int i = 0; i < n; i++) {
        //reverse
        array_p2[0][i] = array_p[n - 1 - i];
        array_p2[1][i] = n - array_p2[0][i] - 1;
        ans[i] = ans_clone[n - 1 - i];
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int a : ans) {
      sb.append(a).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }

  //SegTreeライブラリ
  static class SegTree<S> {

    private final int MAX;
    private final int N;
    private final java.util.function.BinaryOperator<S> op;
    private final S e;
    private final S[] data;

    public SegTree(int n, java.util.function.BinaryOperator<S> op, S e) {
      if (n < 0) {
        String errMsg = String.format("Illegal Size: %d", n);
        throw new IllegalArgumentException(errMsg);
      }
      this.MAX = n;
      int k = 1;
      while (k < n) {
        k <<= 1;
      }
      this.N = k;
      this.e = e;
      this.op = op;
      this.data = (S[]) new Object[N << 1];
      java.util.Arrays.fill(data, e);
    }

    public SegTree(S[] dat, java.util.function.BinaryOperator<S> op, S e) {
      this(dat.length, op, e);
      int l = dat.length;
      System.arraycopy(dat, 0, data, N, l);
      for (int i = N - 1; i > 0; i--) {
        data[i] = op.apply(data[i << 1 | 0], data[i << 1 | 1]);
      }
    }

    public void set(int p, S x) {
      checkIndex(p);
      data[p += N] = x;
      p >>= 1;
      while (p > 0) {
        data[p] = op.apply(data[p << 1 | 0], data[p << 1 | 1]);
        p >>= 1;
      }
    }

    public S get(int p) {
      checkIndex(p);
      return data[p + N];
    }

    public S prod(int l, int r) {
      checkFromToIndex(l, r);
      S sumLeft = e;
      S sumRight = e;
      l += N;
      r += N;
      while (l < r) {
        if ((l & 1) == 1) {
          sumLeft = op.apply(sumLeft, data[l++]);
        }
        if ((r & 1) == 1) {
          sumRight = op.apply(data[--r], sumRight);
        }
        l >>= 1;
        r >>= 1;
      }
      return op.apply(sumLeft, sumRight);
    }

    public S allProd() {
      return data[1];
    }

    public int maxRight(int l, java.util.function.Predicate<S> f) {
      if (!(l >= 0 && l <= MAX)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", l, MAX);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      if (!f.test(e)) {
        throw new IllegalArgumentException("Identity element must satisfy the condition.");
      }
      if (l == MAX) {
        return MAX;
      }
      l += N;
      S sum = e;
      do {
        l >>= Integer.numberOfTrailingZeros(l);
        if (!f.test(op.apply(sum, data[l]))) {
          while (l < N) {
            l = l << 1;
            if (f.test(op.apply(sum, data[l]))) {
              sum = op.apply(sum, data[l]);
              l++;
            }
          }
          return l - N;
        }
        sum = op.apply(sum, data[l]);
        l++;
      } while ((l & -l) != l);
      return MAX;
    }

    public int minLeft(int r, java.util.function.Predicate<S> f) {
      if (!(r >= 0 && r <= MAX)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", r, MAX);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      if (!f.test(e)) {
        throw new IllegalArgumentException("Identity element must satisfy the condition.");
      }
      if (r == 0) {
        return 0;
      }
      r += N;
      S sum = e;
      do {
        r--;
        while (r > 1 && (r & 1) == 1) {
          r >>= 1;
        }
        if (!f.test(op.apply(data[r], sum))) {
          while (r < N) {
            r = r << 1 | 1;
            if (f.test(op.apply(data[r], sum))) {
              sum = op.apply(data[r], sum);
              r--;
            }
          }
          return r + 1 - N;
        }
        sum = op.apply(data[r], sum);
      } while ((r & -r) != r);
      return 0;
    }

    private void checkIndex(int i) {
      if (!(i >= 0 && i < this.MAX)) {
        String msg = String.format("Index %d out of bounds for length %d", i, this.MAX);
        throw new IndexOutOfBoundsException(msg);
      }
    }

    private void checkFromToIndex(int l, int r) {
      if (l < 0 || l > r || r > this.MAX) {
        String msg = String.format("Range [%d, %d) out of bounds for length %d", l, r, this.MAX);
        throw new IndexOutOfBoundsException(msg);
      }
    }
  }
}
