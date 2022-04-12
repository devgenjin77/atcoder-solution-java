/*
 * ac-library
 * FenwickTree
 * https://github.com/atcoder/ac-library/blob/master/document_ja/fenwicktree.md
 */
package library.util;

//FenwickTreeライブラリ
public class FenwickTree {

  final int N;
  long[] data;

  public FenwickTree(int n) {
    N = n;
    this.data = new long[n];
  }

  public FenwickTree(long[] data) {
    N = data.length;
    this.data = new long[this.N];
    System.arraycopy(data, 0, this.data, 0, N);
    for (int i = 1; i <= N; i++) {
      int p = i + (-i & i);
      if (p <= N) {
        this.data[p - 1] += this.data[i - 1];
      }
    }
  }

  public void add(int p, long x) {
    if (!(p >= 0 && p < N)) {
      String errMsg = String.format("Index %d out of bounds for length %d.", p, N);
      throw new ArrayIndexOutOfBoundsException(errMsg);
    }
    p++;
    while (p <= N) {
      data[p - 1] += x;
      p += -p & p;
    }
  }

  public long sum(int l, int r) {
    if (l > r) {
      String errMsg = String.format("Invalid range: [%d, %d).", l, r);
      throw new IllegalArgumentException(errMsg);
    }
    if (!(l >= 0 && l <= N)) {
      String errMsg = String.format("Index %d out of bounds for length %d.", l, N);
      throw new ArrayIndexOutOfBoundsException(errMsg);
    }
    if (!(r >= 0 && r <= N)) {
      String errMsg = String.format("Index %d out of bounds for length %d.", r, N);
      throw new ArrayIndexOutOfBoundsException(errMsg);
    }
    return sum(r) - sum(l);
  }

  private long sum(int r) {
    long s = 0;
    while (r > 0) {
      s += data[r - 1];
      r -= -r & r;
    }
    return s;
  }
}
