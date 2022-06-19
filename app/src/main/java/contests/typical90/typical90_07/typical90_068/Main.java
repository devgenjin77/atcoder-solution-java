/*
 * 競プロ典型90問
 * 068 - Paired Information（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bp
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/32583527
 *
 * note:
 * -クエリ先読み
 *
 */

package contests.typical90.typical90_07.typical90_068;

import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int q = Integer.parseInt(sc.next());
    final int[] array_q = new int[q];
    final int[] array_x = new int[q];
    final int[] array_y = new int[q];
    final long[] array_v = new long[q];
    final long[] idx_to_v = new long[n];
    Arrays.fill(idx_to_v, -1);
    for (int i = 0; i < q; i++) {
      array_q[i] = Integer.parseInt(sc.next());
      array_x[i] = Integer.parseInt(sc.next()) - 1;
      array_y[i] = Integer.parseInt(sc.next()) - 1;
      array_v[i] = Long.parseLong(sc.next());
      if (array_q[i] == 0) {
        idx_to_v[array_y[i]] = array_v[i];
      }
    }
    sc.close();

    final long[] dp = new long[n];
    Arrays.fill(dp, -1);
    for (int i = 1; i < n; i++) {
      if (idx_to_v[i] != -1) {
        if (dp[i - 1] == -1) {
          dp[i - 1] = 0;
        }
        dp[i] = idx_to_v[i] - dp[i - 1];
      }
    }
    DisjointSetUnion dsu = new DisjointSetUnion(n);
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      if (array_q[i] == 0) {
        dsu.merge(array_x[i], array_y[i]);
      } else if (array_q[i] == 1) {
        if (dsu.isSame(array_x[i], array_y[i])) {
          long x_diff = array_v[i] - dp[array_x[i]];
          if ((array_y[i] - array_x[i]) % 2 == 0) {
            pw.println(dp[array_y[i]] + x_diff);
          } else {
            pw.println(dp[array_y[i]] - x_diff);
          }
        } else {
          pw.println("Ambiguous");
        }
      }
    }
    pw.close();
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
