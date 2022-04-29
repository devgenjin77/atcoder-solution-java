/*
 * AtCoder Library Practice Contest
 * A - Disjoint Set Union
 * https://atcoder.jp/contests/practice2/tasks/practice2_a
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/31343353
 *
 */

package contests.practice2.practice2_a;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int q = Integer.parseInt(sc.next());
    DisjointSetUnion dsu = new DisjointSetUnion(n);
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int type = Integer.parseInt(sc.next());
      int u = Integer.parseInt(sc.next());
      int v = Integer.parseInt(sc.next());
      if (type == 0) {
        dsu.merge(u, v);
      } else if (type == 1) {
        pw.println(dsu.isSame(u, v) ? 1 : 0);
      }
    }
    pw.close();
    sc.close();
  }
}

//DisjointSetUnionライブラリ
class DisjointSetUnion {

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
class NextScanner implements AutoCloseable {

  final private java.io.InputStreamReader reader;

  private java.util.StringTokenizer st;

  private static final int BUF_SIZE = 1024;

  private static final char[] buf = new char[BUF_SIZE];

  public NextScanner(java.io.InputStream is) {
    this.reader = new java.io.InputStreamReader(is);
    init();
  }

  private void init() {
    StringBuilder sb = new StringBuilder();
    int len = 0;
    while (true) {
      try {
        int r = this.reader.read(buf, 0, BUF_SIZE);
        if (r < 0) {
          break;
        } else {
          len += r;
          sb.append(buf);
        }
      } catch (java.io.IOException ioe) {
        throw new java.util.InputMismatchException();
      }
    }
    st = new java.util.StringTokenizer(sb.substring(0, len));
  }

  public String next() {
    if (st == null || !st.hasMoreElements()) {
      throw new java.util.NoSuchElementException();
    }
    return st.nextToken();
  }

  @Override
  public void close() throws Exception {
    reader.close();
  }
}
