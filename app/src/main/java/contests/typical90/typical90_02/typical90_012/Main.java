/*
 * 競プロ典型90問
 * 012 - Red Painting（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_l
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31895831
 *
 * note:
 * Union-Findを使って連結判定を行う
 *
 */

package contests.typical90.typical90_02.typical90_012;

import java.io.PrintWriter;

public class Main {

  static final int[] dr = new int[]{-1, 1, 0, 0};
  static final int[] dc = new int[]{0, 0, -1, 1};

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int h = Integer.parseInt(sc.next());
    int w = Integer.parseInt(sc.next());
    int q = Integer.parseInt(sc.next());
    DisjointSetUnion dsu = new DisjointSetUnion(h * w);
    boolean[] isRed = new boolean[h * w];
    PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 1; cnt <= q; cnt++) {
      int type = Integer.parseInt(sc.next());
      if (type == 1) {
        int r = Integer.parseInt(sc.next()) - 1;
        int c = Integer.parseInt(sc.next()) - 1;
        int pos = (r * w) + c;
        isRed[pos] = true;
        for (int i = 0; i < 4; i++) {
          int next_r = r + dr[i];
          int next_c = c + dc[i];
          if (!(next_r >= 0 && next_r < h && next_c >= 0 && next_c < w)) {
            continue;
          }
          int next_pos = (next_r * w) + next_c;
          if (isRed[next_pos]) {
            dsu.merge(pos, next_pos);
          }
        }
      } else if (type == 2) {
        int ra = Integer.parseInt(sc.next()) - 1;
        int ca = Integer.parseInt(sc.next()) - 1;
        int rb = Integer.parseInt(sc.next()) - 1;
        int cb = Integer.parseInt(sc.next()) - 1;
        int pos_a = (ra * w) + ca;
        int pos_b = (rb * w) + cb;
        pw.println(isRed[pos_a] && isRed[pos_b] && dsu.isSame(pos_a, pos_b) ? "Yes" : "No");
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
