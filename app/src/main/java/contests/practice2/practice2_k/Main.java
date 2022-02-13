/*
 * AtCoder Library Practice Contest
 * K - Range Affine Range Sum
 * https://atcoder.jp/contests/practice2/tasks/practice2_k
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/29258163
 *
 * 注意事項
 * TLE対策のため、ラムダ式記述の一部を削除することで高速化を図った。
 */
package contests.practice2.practice2_k;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {

  static final long MOD = 998244353l;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nq = br.readLine().split(" ");
    int n = Integer.parseInt(nq[0]);
    int q = Integer.parseInt(nq[1]);
    StructS[] data = new StructS[n];
    String[] array = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      data[i] = new StructS(Long.parseLong(array[i]), 1l);
    }
    //区間加算・区間和取得
    LazySegTree lazySegTree = new LazySegTree(data);
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    for (int cnt = 0; cnt < q; cnt++) {
      String[] query = br.readLine().split(" ");
      int type = Integer.parseInt(query[0]);
      int l = Integer.parseInt(query[1]);
      int r = Integer.parseInt(query[2]);
      switch (type) {
        case 0:
          long b = Long.parseLong(query[3]);
          long c = Long.parseLong(query[4]);
          lazySegTree.apply(l, r, new StructT(b, c));
          break;
        case 1:
          pw.println(lazySegTree.prod(l, r).sum);
          break;
        default:
          break;
      }
    }
    pw.close();
    br.close();
  }

  static class StructS {

    long sum, len;

    StructS(long sum, long len) {
      this.sum = sum;
      this.len = len;
    }
  }

  static class StructT {

    long val1, val2;

    StructT(long val1, long val2) {
      this.val1 = val1;
      this.val2 = val2;
    }
  }

  static class LazySegTree {

    private final int _n;
    private final int size;
    private final int log;
    private final StructS[] data;
    private final StructT[] lazy;

    private final StructS e = new StructS(0l, 0l); //単位元
    private final StructT id = new StructT(1l, 0l); //恒等写像

    LazySegTree(int n) {
      if (n < 0) {
        throw new IllegalArgumentException("Illegal size: " + n);
      }
      this._n = n;

      this.log = ceilPow2(_n);
      this.size = 1 << this.log;
      this.data = new StructS[this.size << 1];
      this.lazy = new StructT[this.size];
      java.util.Arrays.fill(data, e);
      java.util.Arrays.fill(lazy, id);
    }

    LazySegTree(StructS[] data) {
      this(data.length);
      System.arraycopy(data, 0, this.data, this.size, data.length);
      for (int i = this.size - 1; i >= 1; i--) {
        update(i);
      }
    }

    static StructS op(StructS s1, StructS s2){
      return new StructS((s1.sum + s2.sum) % MOD, s1.len + s2.len);
    }

    static StructS mapping(StructT f, StructS s){
      return new StructS(((f.val1 * s.sum) + (f.val2 * s.len)) % MOD, s.len);
    }

    static StructT composition(StructT f1, StructT f2){
      return new StructT((f1.val1 * f2.val1) % MOD, ((f1.val1 * f2.val2) + f1.val2) % MOD);
    }

    void set(int p, StructS x) {
      java.util.Objects.checkIndex(p, this._n);
      p += this.size;
      pushTo(p);
      this.data[p] = x;
      updateParent(p);
    }

    StructS get(int p) {
      java.util.Objects.checkIndex(p, this._n);
      p += this.size;
      pushTo(p);
      return this.data[p];
    }

    StructS prod(int l, int r) {
      java.util.Objects.checkFromToIndex(l, r, this._n);
      if (l == r) {
        return e;
      }

      l += this.size;
      r += this.size;
      pushTo(l, r);
      StructS sum_left = e, sum_right = e;
      while (l < r) {
        if ((l & 1) == 1) {
          //sum_left = op.apply(sum_left, this.data[l++]);
          sum_left = op(sum_left, this.data[l++]);
        }
        if ((r & 1) == 1) {
          //sum_right = op.apply(this.data[--r], sum_right);
          sum_right = op(this.data[--r], sum_right);
        }
        l >>= 1;
        r >>= 1;
      }
      //return op.apply(sum_left, sum_right);
      return op(sum_left, sum_right);
    }

    StructS allProd() {
      return this.data[1];
    }

    void apply(int p, StructT f) {
      java.util.Objects.checkIndex(p, this._n);
      p += this.size;
      pushTo(p);
      //this.data[p] = mapping.apply(f, data[p]);
      this.data[p] = mapping(f, data[p]);
      updateParent(p);
    }

    void apply(int l, int r, StructT f) {
      java.util.Objects.checkFromToIndex(l, r, this._n);
      if (l == r) {
        return;
      }
      l += this.size;
      r += this.size;
      pushTo(l, r);

      int l2 = l, r2 = r;
      while (l2 < r2) {
        if ((l2 & 1) == 1) {
          allApply(l2++, f);
        }
        if ((r2 & 1) == 1) {
          allApply(--r2, f);
        }
        l2 >>= 1;
        r2 >>= 1;
      }
      updateParent(l, r);
    }

    private void update(int k) {
      //this.data[k] = this.op.apply(this.data[k << 1 | 0], this.data[k << 1 | 1]);
      this.data[k] = op(this.data[k << 1 | 0], this.data[k << 1 | 1]);
    }

    private void updateParent(int k) {
      for (int i = 1; i <= this.log; i++) {
        update(k >> i);
      }
    }

    private void updateParent(int l, int r) {
      for (int i = 1; i <= log; i++) {
        if (((l >> i) << i) != l) {
          update(l >> i);
        }
        if (((r >> i) << i) != r) {
          update((r - 1) >> i);
        }
      }
    }

    private void allApply(int k, StructT f) {
      //this.data[k] = mapping.apply(f, this.data[k]);
      this.data[k] = mapping(f, this.data[k]);
      if (k < this.size) {
        //this.lazy[k] = composition.apply(f, this.lazy[k]);
        this.lazy[k] = composition(f, this.lazy[k]);
      }
    }

    private void push(int k) {
      allApply(k << 1 | 0, lazy[k]);
      allApply(k << 1 | 1, lazy[k]);
      lazy[k] = id;
    }

    private void pushTo(int k) {
      for (int i = this.log; i >= 1; i--) {
        push(k >> i);
      }
    }

    private void pushTo(int l, int r) {
      for (int i = this.log; i >= 1; i--) {
        if (((l >> i) << i) != l) {
          push(l >> i);
        }
        if (((r >> i) << i) != r) {
          push((r - 1) >> i);
        }
      }
    }

    private static int ceilPow2(int n) {
      int x = 0;
      while ((1 << x) < n) {
        x++;
      }
      return x;
    }
  }
}
