/*
 * AtCoder Beginner Contest 230
 * D - Destroyer Takahashi
 * https://atcoder.jp/contests/abc230/tasks/abc230_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/33887018
 *
 * note:
 * 右端の位置が最も左にくる順で、壁の右端にパンチするのが最適
 *
 */

package contests.abc.abc23x.abc230.abc230_d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int d = Integer.parseInt(sc.next());
    final List<Wall> list_wall = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int l = Integer.parseInt(sc.next());
      int r = Integer.parseInt(sc.next());
      Wall wall = new Wall(l, r);
      list_wall.add(wall);
    }
    sc.close();
    Collections.sort(list_wall, new Comparator<Wall>() {
      @Override
      public int compare(Wall o1, Wall o2) {
        if (o1.r != o2.r) {
          return Integer.compare(o1.r, o2.r);
        } else {
          return Integer.compare(o1.l, o2.l);
        }
      }
    });
    int ans = 1, p = list_wall.get(0).r;
    for (int i = 1; i < n; i++) {
      int wall_l = list_wall.get(i).l;
      if (p + d - 1 < wall_l) {
        //先のパンチで壊せない。この壁の左端でパンチする
        p = list_wall.get(i).r;
        ans++;
      }
    }
    System.out.println(ans);
  }

  static class Wall {

    int l, r;

    public Wall(int l, int r) {
      this.l = l;
      this.r = r;
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
