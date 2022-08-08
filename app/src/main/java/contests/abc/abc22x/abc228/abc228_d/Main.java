/*
 * トヨタシステムズプログラミングコンテスト2021
 * （AtCoder Beginner Contest 228）
 * D - Linear Probing
 * https://atcoder.jp/contests/abc228/tasks/abc228_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc228/submissions/33878666
 *
 * note:
 * Union-Findを使って、区間の連結を管理する。
 *
 */

package contests.abc.abc22x.abc228.abc228_d;

import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  final static int N = 1 << 20;

  final static long MASK = (1L << 20) - 1;

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final DisjointSetUnion dsu = new DisjointSetUnion(N);
    final long[] array_a = new long[N];
    Arrays.fill(array_a, -1);
    final int[] next_idx = new int[N];
    for (int i = 0; i < N; i++) {
      next_idx[i] = i;
    }
    final int q = Integer.parseInt(sc.next());
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int t = Integer.parseInt(sc.next());
      long x = Long.parseLong(sc.next());
      int mod_n = (int) (x & MASK);
      if (t == 1) {
        int target = next_idx[dsu.leader(mod_n)];
        array_a[target] = x;
        int next = (int) ((target + 1) & MASK);
        int next_target = next_idx[dsu.leader(next)];
        dsu.merge(target, next);
        next_idx[dsu.leader(target)] = next_target;
      } else if (t == 2) {
        pw.println(array_a[mod_n]);
      }
    }
    pw.close();
    sc.close();
  }

  //DisjointSetUnionライブラリ
  static class DisjointSetUnion {

    private final int n;
    private final int[] parent_or_size;

    public DisjointSetUnion(int n) {
      this.n = n;
      parent_or_size = new int[n];
      java.util.Arrays.fill(parent_or_size, -1);
    }

    public int merge(int a, int b) {
      if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
        return -1;
      }
      int x = leader(a);
      int y = leader(b);
      if (x == y) {
        return x;
      }
      if (-parent_or_size[x] < -parent_or_size[y]) {
        int temp = x;
        x = y;
        y = temp;
      }
      parent_or_size[x] += parent_or_size[y];
      parent_or_size[y] = x;
      return x;
    }

    public boolean isSame(int a, int b) {
      if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
        return false;
      }
      return leader(a) == leader(b);
    }

    public int leader(int a) {
      if (parent_or_size[a] < 0) {
        return a;
      } else {
        parent_or_size[a] = leader(parent_or_size[a]);
        return parent_or_size[a];
      }
    }

    public int size(int a) {
      if (!(0 <= a && a < n)) {
        return -1;
      }
      return -parent_or_size[leader(a)];
    }

    public java.util.List<java.util.List<Integer>> groups() {
      int m = 0;
      java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
      java.util.Map<Integer, Integer> map_leader = new java.util.HashMap<>();
      for (int i = 0; i < n; i++) {
        int lead = leader(i);
        if (!map_leader.containsKey(lead)) {
          map_leader.put(lead, m++);
          result.add(new java.util.ArrayList<>());
        }
        result.get(map_leader.get(lead)).add(i);
      }
      return result;
    }
  }

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    private final java.io.BufferedReader br;

    private java.util.StringTokenizer st;

    private static final int BUF_SIZE = 1 << 16;

    private static final char[] c_buf = new char[BUF_SIZE];

    public NextScanner(java.io.InputStream input) {
      this.br = new java.io.BufferedReader(new java.io.InputStreamReader(input));
    }

    private java.util.StringTokenizer readInput() {
      java.util.StringTokenizer st;
      try {
        int b = br.read(c_buf);
        if (b == BUF_SIZE) {
          StringBuilder sb = new StringBuilder();
          sb.append(c_buf);
          sb.append(br.readLine());
          st = new java.util.StringTokenizer(sb.toString());
        } else if (b < 0) {
          throw new java.util.NoSuchElementException();
        } else {
          st = new java.util.StringTokenizer(new String(c_buf, 0, b));
        }
      } catch (java.io.IOException e) {
        throw new java.util.InputMismatchException(e.getMessage());
      }
      return st;
    }

    public String next() throws java.io.IOException {
      if (st == null || !st.hasMoreElements()) {
        st = readInput();
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      br.close();
    }
  }
}
