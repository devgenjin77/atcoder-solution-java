/*
 * AtCoder Library Practice Contest
 * J - Segment Tree
 * https://atcoder.jp/contests/practice2/tasks/practice2_j
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/31347453
 *
 */

package contests.practice2.practice2_j;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int q = Integer.parseInt(sc.next());
    Integer[] array_a = new Integer[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
    }
    SegTree<Integer> segTree = new SegTree<>(array_a, Integer::max, -1);
    PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 1; cnt <= q; cnt++) {
      int t = Integer.parseInt(sc.next());
      if (t == 1) {
        int x = Integer.parseInt(sc.next()) - 1;
        int v = Integer.parseInt(sc.next());
        segTree.set(x, v);
      } else if (t == 2) {
        int l = Integer.parseInt(sc.next()) - 1;
        int r = Integer.parseInt(sc.next());
        pw.println(segTree.prod(l, r));
      } else if (t == 3) {
        int x = Integer.parseInt(sc.next()) - 1;
        int v = Integer.parseInt(sc.next());
        pw.println(segTree.maxRight(x, val -> val < v) + 1);
      }
    }
    pw.close();
    sc.close();
  }
}

//SegTreeライブラリ
class SegTree<S> {

  final int MAX;
  final int N;
  final java.util.function.BinaryOperator<S> op;
  final S e;
  final S[] data;

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
    java.util.Objects.checkIndex(p, MAX);
    data[p += N] = x;
    p >>= 1;
    while (p > 0) {
      data[p] = op.apply(data[p << 1 | 0], data[p << 1 | 1]);
      p >>= 1;
    }
  }

  public S get(int p) {
    java.util.Objects.checkIndex(p, MAX);
    return data[p + N];
  }

  public S prod(int l, int r) {
    java.util.Objects.checkFromToIndex(l, r, MAX);
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
}

//NextScannerライブラリ
class NextScanner implements AutoCloseable {

  final private java.io.InputStreamReader reader;

  private java.util.StringTokenizer st;

  private static final int BUF_SIZE = 1024;

  private static final char[] buf = new char[BUF_SIZE];

  public NextScanner(java.io.InputStream is) {
    this.reader = new java.io.InputStreamReader(is);
  }

  private void readInput() {
    StringBuilder sb = new StringBuilder();
    try {
      int len = this.reader.read(buf, 0, BUF_SIZE);
      if (len < 0) {
        throw new java.util.NoSuchElementException();
      } else {
        sb.append(buf);
        if (len == BUF_SIZE) {
          int b = this.reader.read();
          while (33 <= b && b <= 126) {
            sb.appendCodePoint(b);
            len++;
            b = this.reader.read();
          }
        }
      }
      st = new java.util.StringTokenizer(sb.substring(0, len));
    } catch (java.io.IOException ioe) {
      throw new java.util.InputMismatchException();
    }
  }

  public String next() {
    if (st == null || !st.hasMoreElements()) {
      readInput();
    }
    return st.nextToken();
  }

  @Override
  public void close() throws Exception {
    reader.close();
  }
}
